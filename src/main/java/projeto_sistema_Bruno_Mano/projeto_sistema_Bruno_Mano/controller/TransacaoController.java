package projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.dto.TransacaoDTO;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.service.TransacaoService;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping("/saque")
    @Transactional
    public ResponseEntity<String> realizarSaque(@RequestBody @Valid TransacaoDTO transacaoDTO){
        transacaoService.saque(transacaoDTO);
        return new ResponseEntity<>("Seu saque foi concluído com sucesso!", HttpStatus.OK);
    }

    @PostMapping("/deposito")
    @Transactional
    public ResponseEntity<String> realizarDeposito(@RequestBody @Valid TransacaoDTO transacaoDTO){
        transacaoService.deposito(transacaoDTO);
        return new ResponseEntity<>("Seu deposito foi concluído com sucesso!", HttpStatus.OK);
    }
}
