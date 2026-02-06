package projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ContaCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    private float saldo;

    private boolean status;

    public ContaCliente(Cliente cliente, Empresa empresa) {
        this.cliente = cliente;
        this.empresa = empresa;
        this.status = true;
    }
}
