package projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.dto.CadastroClienteDTO;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCompleto;

    private String cpf;

    private String dataNascimento;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    public Cliente(CadastroClienteDTO cadastroCliente) {
        this.nomeCompleto = cadastroCliente.nome();
        this.cpf = cadastroCliente.cpf();
        this.dataNascimento = cadastroCliente.dataNascimento();
        this.genero = Genero.valueOf(cadastroCliente.genero());
        this.email = cadastroCliente.email();
        this.endereco = new Endereco(cadastroCliente.endereco());
    }

    public Cliente(String nomeCompleto, String cpf, String dataNascimento, Genero genero, String email, Endereco endereco) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.email = email;
        this.endereco = endereco;
    }
}
