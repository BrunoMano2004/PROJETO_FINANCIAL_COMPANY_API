package projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.dto.CadastroEnderecoDTO;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logradouro;

    private int numero;

    private String bairro;

    private String cidade;

    private String uf;

    private String cep;

    private String complemento;

    public Endereco(CadastroEnderecoDTO cadastroEndereco) {
        this.logradouro = cadastroEndereco.logradouro();
        this.numero = cadastroEndereco.numero();
        this.bairro = cadastroEndereco.bairro();
        this.cidade = cadastroEndereco.cidade();
        this.uf = cadastroEndereco.uf();
        this.cep = cadastroEndereco.cep();
        this.complemento = cadastroEndereco.complemento();
    }
}
