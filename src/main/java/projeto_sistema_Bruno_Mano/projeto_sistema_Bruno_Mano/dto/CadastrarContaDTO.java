package projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastrarContaDTO(

        @NotBlank
        String clienteCpf,

        @NotBlank
        String empresaCnpj
) {}
