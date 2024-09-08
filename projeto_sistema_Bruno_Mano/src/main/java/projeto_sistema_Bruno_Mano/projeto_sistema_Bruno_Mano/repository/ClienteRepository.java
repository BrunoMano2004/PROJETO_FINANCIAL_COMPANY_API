package projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.model.Cliente;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByCpf(String cpf);
}
