package projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.dto.CadastroClienteDTO;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.dto.ClienteDTO;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.exception.ResourceDuplicatedException;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.exception.ResourceNotFoundException;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.model.Cliente;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.repository.ClienteRepository;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteDTO> listaDeClientes(){
        List<ClienteDTO> clientes = clienteRepository.findAll()
                .stream()
                .map(ClienteDTO::new)
                .toList();

        return clientes;
    }

    public ClienteDTO retornarClientePorCpf(String cpf){
        Cliente cliente = clienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com o CPF digitado"));

        return new ClienteDTO(cliente);
    }

    public void cadastrarCliente(CadastroClienteDTO cadastroCliente){
        if(clienteRepository.findByCpf(cadastroCliente.cpf()).isPresent()){
            throw new ResourceDuplicatedException("CPF já cadastrado!");
        } else {
            clienteRepository.save(new Cliente(cadastroCliente));
        }
    }
}
