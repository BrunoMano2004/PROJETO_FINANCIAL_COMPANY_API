package projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.dto.CadastroClienteDTO;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.dto.ClienteDTO;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> retornarTodosCliente(){
        List<ClienteDTO> clientes = clienteService.listaDeClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ClienteDTO> retornarClientePorCpf(@PathVariable String cpf){
        ClienteDTO cliente = clienteService.retornarClientePorCpf(cpf);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<String> cadastrarCliente(@RequestBody @Valid CadastroClienteDTO cadastroCliente){
        clienteService.cadastrarCliente(cadastroCliente);
        return new ResponseEntity<>("Cliente criada com sucesso", HttpStatus.CREATED);
    }
}
