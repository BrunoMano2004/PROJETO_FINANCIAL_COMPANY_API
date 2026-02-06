package projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.model.Endereco;

public record CadastroEnderecoDTO(

        @NotBlank
        String logradouro,

        @NotNull
        int numero,

        @NotBlank
        String bairro,

        @NotBlank
        String cidade,

        @NotBlank
        String uf,

        @NotBlank
        String cep,
        String complemento
) {
}
