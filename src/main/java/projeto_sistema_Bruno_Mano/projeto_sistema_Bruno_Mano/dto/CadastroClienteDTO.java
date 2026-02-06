package projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.model.Cliente;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.model.Genero;

public record CadastroClienteDTO(

        @NotBlank(message = "Nome não pode estar vazio")
        String nome,

        @NotBlank
        @Pattern(regexp = "^\\d{11}$", message = "Deve conter exatamente 11 dígitos numéricos")
        String cpf,

        @NotBlank
        String dataNascimento,

        @NotNull
        String genero,

        @NotBlank
        @Email
        String email,

        @NotNull
        CadastroEnderecoDTO endereco
) {}
