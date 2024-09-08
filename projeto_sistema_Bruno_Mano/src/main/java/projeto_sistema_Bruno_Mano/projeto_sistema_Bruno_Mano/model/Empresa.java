package projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.dto.CadastroEmpresaDTO;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.dto.CadastroEnderecoDTO;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String razaoSocial;

    private String cnpj;

    private String ramo;

    private float saldo;

    private float taxaTransacao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    public Empresa(CadastroEmpresaDTO cadastroEmpresa) {
        this.nome = cadastroEmpresa.nome();
        this.razaoSocial = cadastroEmpresa.razaoSocial();
        this.cnpj = cadastroEmpresa.cnpj();
        this.ramo = cadastroEmpresa.ramo();
        this.taxaTransacao = cadastroEmpresa.taxaTransacao();
        this.endereco = new Endereco(cadastroEmpresa.endereco());
    }
}
