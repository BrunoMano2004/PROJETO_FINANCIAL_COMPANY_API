package projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
