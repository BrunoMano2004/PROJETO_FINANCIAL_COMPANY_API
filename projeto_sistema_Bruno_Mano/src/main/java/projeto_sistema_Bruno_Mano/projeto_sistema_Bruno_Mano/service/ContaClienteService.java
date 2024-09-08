package projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.dto.CadastrarContaDTO;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.dto.ContaClienteDTO;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.exception.ResourceNotFoundException;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.model.Cliente;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.model.ContaCliente;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.model.Empresa;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.repository.ClienteRepository;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.repository.ContaClienteRepository;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.repository.EmpresaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContaClienteService {

    @Autowired
    ContaClienteRepository contaClienteRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EmpresaRepository empresaRepository;

    public List<ContaClienteDTO> retornarContasPorCliente(String cpf){

        List<ContaCliente> contasClientes = contaClienteRepository.encontrarContaAtivaPorCpfDoCliente(cpf);

        if(!contasClientes.isEmpty()){
            List<ContaClienteDTO> contas = contasClientes
                    .stream()
                    .map(ContaClienteDTO::new)
                    .toList();

            return contas;
        } else {
            throw new ResourceNotFoundException("Não foi encontrada nenhuma conta com esse cpf");
        }
    }

    public void cadastrarConta(CadastrarContaDTO cadastrarConta) {
        Cliente cliente = clienteRepository.findByCpf(cadastrarConta.clienteCpf())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));

        Empresa empresa = empresaRepository.findByCnpj(cadastrarConta.empresaCnpj())
                .orElseThrow(() -> new ResourceNotFoundException("Empresa não encontrada"));

        contaClienteRepository.save(new ContaCliente(cliente, empresa));
    }

    public void desativarContaCliente(Long id){
        ContaCliente conta = contaClienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Conta não encontrada!"));

        if (conta.getSaldo() != 0.00){
            throw new RuntimeException("Há saldo restante, não é possível destivar sua conta");
        } else {
            conta.setStatus(false);
        }
    }
}
