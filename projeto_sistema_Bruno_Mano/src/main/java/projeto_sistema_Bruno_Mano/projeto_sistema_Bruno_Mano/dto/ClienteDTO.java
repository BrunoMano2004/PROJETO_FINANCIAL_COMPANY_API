package projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.dto;

import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.model.Cliente;

public record ClienteDTO(
        String nome,
        String cpf,
        String dataNascimento,
        String genero,

        String email,
        EnderecoDTO endereco
) {
    public ClienteDTO(Cliente cliente) {
        this(cliente.getNomeCompleto(), cliente.getCpf(), cliente.getDataNascimento(), String.valueOf(cliente.getGenero()), cliente.getEmail(), new EnderecoDTO(cliente.getEndereco()));
    }
}
