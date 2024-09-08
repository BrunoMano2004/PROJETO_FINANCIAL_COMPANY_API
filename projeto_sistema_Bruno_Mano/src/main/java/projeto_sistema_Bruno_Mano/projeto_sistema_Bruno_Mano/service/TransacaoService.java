package projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.dto.TransacaoDTO;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.exception.FinancialErrorException;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.exception.ResourceNotFoundException;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.model.ContaCliente;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.model.TipoTransacao;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.model.Transacao;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.repository.ContaClienteRepository;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.repository.TransacaoRepository;

@Service
public class TransacaoService {

    @Autowired
    private CallbackService callbackService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private ContaClienteRepository contaClienteRepository;

    public void saque(TransacaoDTO transacaoDTO){

        ContaCliente conta = contaClienteRepository.findById(transacaoDTO.contaId())
                .orElseThrow(() -> new ResourceNotFoundException("Conta não encontrada"));

        if (conta.isStatus()){
            if (conta.getSaldo() < transacaoDTO.valorBruto()){
                throw new FinancialErrorException("Seu saldo não é suficiente para esse saque");
            } else {
                conta.setSaldo(conta.getSaldo() - transacaoDTO.valorBruto());
            }

            float valorLiquido = transacaoDTO.valorBruto() - conta.getEmpresa().getTaxaTransacao();

            conta.getEmpresa().setSaldo(conta.getEmpresa().getSaldo() - valorLiquido);

            Transacao transacao = new Transacao(conta, TipoTransacao.SAQUE, transacaoDTO.valorBruto(), conta.getEmpresa().getTaxaTransacao(), valorLiquido);

            transacaoRepository.save(transacao);

            enviarAvisos(transacao);
        } else {
            throw new RuntimeException("Conta desativada! Não é possível realizar transações!");
        }
    }

    public void deposito(TransacaoDTO transacaoDTO) {
        ContaCliente conta = contaClienteRepository.findById(transacaoDTO.contaId())
                .orElseThrow(() -> new ResourceNotFoundException("Conta não encontrada"));

        if (conta.isStatus()){
            conta.setSaldo(conta.getSaldo() + transacaoDTO.valorBruto());
            conta.getEmpresa().setSaldo(conta.getEmpresa().getSaldo() + transacaoDTO.valorBruto());

            Transacao transacao = new Transacao(conta, TipoTransacao.DEPOSITO, transacaoDTO.valorBruto(), 0, transacaoDTO.valorBruto());

            transacaoRepository.save(transacao);
        } else {
            throw new RuntimeException("Conta desativada! Não é possível realizar transações!");
        }
    }

    private void enviarAvisos(Transacao transacao){
        String urlCallbackEmpresa = "https://webhook.site/seu-url";
        callbackService.enviarCallback(urlCallbackEmpresa, transacao);

        emailService.enviarEmail(transacao.getContaCliente().getCliente().getEmail(), "Transação realizada", "Sua transação foi concluída com sucesso.");
    }
}