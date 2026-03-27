package br.ufg.inf.onboarding.controller;

import br.ufg.inf.onboarding.model.Usuario;
import br.ufg.inf.onboarding.repository.UsuarioRepository;

import br.ufg.inf.onboarding.validators.CpfValidator;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Usuario usuario) {
        if (!CpfValidator.isValid(usuario.getCpf())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CPF inválido");
        }
        Usuario salvo = usuarioRepository.save(usuario);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping
    public List<Usuario> listar(@RequestParam(value = "nome", required = false) String nome) {
        if (nome != null && !nome.isEmpty()) {
            return usuarioRepository.findByNomeContainingIgnoreCase(nome);
        }
        return usuarioRepository.findAll();
    }
}
