package projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.model.Empresa;

public record CadastroEmpresaDTO(

        @NotBlank
        String nome,

        @NotBlank
        String razaoSocial,

        @NotBlank
        @Pattern(regexp = "^\\d{14}$", message = "Deve conter exatamente 14 dígitos numéricos")
        String cnpj,

        @NotBlank
        String ramo,

        @NotNull
        float saldo,

        @NotNull
        float taxaTransacao,

        @NotNull
        @Valid
        CadastroEnderecoDTO endereco

) {
}
