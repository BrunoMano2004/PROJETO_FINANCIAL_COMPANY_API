package projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.dto.CadastroEmpresaDTO;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.dto.CadastroEnderecoDTO;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.dto.EmpresaDTO;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.exception.ResourceDuplicatedException;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.exception.ResourceNotFoundException;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.model.Empresa;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.repository.EmpresaRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<EmpresaDTO> retornarTodasEmpresas(){
        return empresaRepository
                .findAll()
                .stream()
                .map(EmpresaDTO::new)
                .toList();
    }

    public EmpresaDTO retornarEmpresaPeloCnpj(String cnpj){
        Empresa empresa = empresaRepository.findByCnpj(cnpj)
                .orElseThrow(() -> new ResourceNotFoundException("Empresa especificada não encontrada"));

        return new EmpresaDTO(empresa);
    }

    public void cadastrarEmpresa(CadastroEmpresaDTO cadastroEmpresa){
        if (empresaRepository.findByCnpj(cadastroEmpresa.cnpj()).isPresent()){
            throw new ResourceDuplicatedException("CNPJ já cadastrado no sistema!");
        } else {
            empresaRepository.save(new Empresa(cadastroEmpresa));
        }
    }
}
