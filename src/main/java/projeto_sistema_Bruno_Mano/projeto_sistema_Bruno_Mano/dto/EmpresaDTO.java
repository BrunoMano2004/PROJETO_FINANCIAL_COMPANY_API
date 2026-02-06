package projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.dto;

import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.model.Empresa;

public record EmpresaDTO(
        String nome,
        String razaoSocial,
        String cnpj,
        String ramo,
        float saldo,
        float taxaTransacao,
        EnderecoDTO endereco
) {
    public EmpresaDTO(Empresa empresa){
        this(empresa.getNome(), empresa.getRazaoSocial(), empresa.getCnpj(), empresa.getRamo(), empresa.getSaldo(), empresa.getTaxaTransacao(), new EnderecoDTO(empresa.getEndereco()));
    }
}
