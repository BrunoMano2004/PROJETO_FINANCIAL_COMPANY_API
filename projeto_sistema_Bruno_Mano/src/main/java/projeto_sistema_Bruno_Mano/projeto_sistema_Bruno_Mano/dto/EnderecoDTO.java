package projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.dto;

import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.model.Endereco;

public record EnderecoDTO(
        String logradouro,
        int numero,
        String bairro,
        String cidade,
        String uf,
        String cep,
        String complemento
) {
    public EnderecoDTO(Endereco endereco){
        this(endereco.getLogradouro(), endereco.getNumero(), endereco.getBairro(), endereco.getCidade(), endereco.getUf(), endereco.getCep(), endereco.getComplemento());
    }
}
