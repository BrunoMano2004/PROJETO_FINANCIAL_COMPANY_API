package projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.model.Empresa;

import java.util.Optional;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    Optional<Empresa> findByCnpj(String cnpj);
}
