package projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.dto.TransacaoDTO;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_conta_cliente")
    private ContaCliente contaCliente;

    @Enumerated(EnumType.STRING)
    private TipoTransacao tipoTransacao;

    private float valorBruto;

    private float taxaCobrada;

    private float valorLiquido;

    public Transacao(ContaCliente contaCliente, TipoTransacao tipoTransacao, float valorBruto, float taxaCobrada, float valorLiquido) {
        this.contaCliente = contaCliente;
        this.tipoTransacao = tipoTransacao;
        this.valorBruto = valorBruto;
        this.valorLiquido = valorLiquido;
        this.taxaCobrada = taxaCobrada;
    }
}
