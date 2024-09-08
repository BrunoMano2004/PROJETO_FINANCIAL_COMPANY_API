package projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.model.ContaCliente;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContaClienteRepository extends JpaRepository<ContaCliente, Long> {

    @Query("SELECT cc FROM ContaCliente cc JOIN cc.cliente c WHERE c.cpf = :cpf AND cc.status = true")
    List<ContaCliente> encontrarContaAtivaPorCpfDoCliente(String cpf);
}
