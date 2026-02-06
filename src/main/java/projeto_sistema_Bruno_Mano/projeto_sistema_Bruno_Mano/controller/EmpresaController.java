package projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.dto.CadastroEmpresaDTO;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.dto.CadastroEnderecoDTO;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.dto.EmpresaDTO;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.service.EmpresaService;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public ResponseEntity<List<EmpresaDTO>> listarEmpresas(){
        List<EmpresaDTO> empresas = empresaService.retornarTodasEmpresas();
        return ResponseEntity.ok(empresas);
    }

    @GetMapping("/{cnpj}")
    public ResponseEntity<EmpresaDTO> ListarEmpresaPeloCnpj(@PathVariable String cnpj){
        EmpresaDTO empresa = empresaService.retornarEmpresaPeloCnpj(cnpj);
        return ResponseEntity.ok(empresa);
    }

    @PostMapping
    public ResponseEntity<String> CadastrarEmpresa(@RequestBody @Valid CadastroEmpresaDTO cadastroEmpresa){
        empresaService.cadastrarEmpresa(cadastroEmpresa);
        return new ResponseEntity<>("Empresa criada com sucesso", HttpStatus.CREATED);
    }
}
