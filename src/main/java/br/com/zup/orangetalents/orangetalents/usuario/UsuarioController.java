package br.com.zup.orangetalents.orangetalents.usuario;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

//	public UsuarioController(UsuarioRepository usuarioRepository) {
//		this.usuarioRepository = usuarioRepository;
//	}

	@PostMapping
	public ResponseEntity<?> cadastrarUsuario(@RequestBody @Valid UsuarioRequest request) {
		if(usuarioRepository.existsByEmail(request.getEmail()) || usuarioRepository.existsByCpf(request.getCpf())) {
	        return ResponseEntity.badRequest().build();
	    }

		Usuario novoUsuario = request.paraUsuario();
		usuarioRepository.save(novoUsuario);
		return ResponseEntity.status(HttpStatus.CREATED).build();
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> consultarUsuario(@PathVariable Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		if(!usuario.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
		}
		
		return ResponseEntity.ok(new UsuarioResponse(usuario.get()));
	}
}
