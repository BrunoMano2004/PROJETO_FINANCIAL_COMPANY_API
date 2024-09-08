package projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.dto.CadastrarContaDTO;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.dto.ContaClienteDTO;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.service.ContaClienteService;

import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaClienteController {

    @Autowired
    ContaClienteService contaClienteService;

    @GetMapping("/{cpf}")
    public ResponseEntity<List<ContaClienteDTO>> buscarContaPorCliente(@PathVariable String cpf){
        List<ContaClienteDTO> contasCliente = contaClienteService.retornarContasPorCliente(cpf);
        return ResponseEntity.ok(contasCliente);
    }

    @PostMapping
    public ResponseEntity<String> criarNovaConta(@RequestBody @Valid CadastrarContaDTO cadastrarConta){
        contaClienteService.cadastrarConta(cadastrarConta);
        return new ResponseEntity<>("Conta cadastrada com sucesso!", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> desativarConta(@PathVariable Long id){
        contaClienteService.desativarContaCliente(id);
        return new ResponseEntity<>("Sua conta foi desativada com sucesso", HttpStatus.OK);
    }
}
