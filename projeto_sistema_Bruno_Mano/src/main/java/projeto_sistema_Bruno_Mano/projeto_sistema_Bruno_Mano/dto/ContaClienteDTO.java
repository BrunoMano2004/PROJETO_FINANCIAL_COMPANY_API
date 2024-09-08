package projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.dto;

import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.model.Cliente;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.model.ContaCliente;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.model.Empresa;

public record ContaClienteDTO(
        Cliente cliente,
        Empresa empresa,
        float saldo,

        boolean status
) {
    public ContaClienteDTO(ContaCliente contaCliente){
        this(contaCliente.getCliente(), contaCliente.getEmpresa(), contaCliente.getSaldo(), contaCliente.isStatus());
    }
}
