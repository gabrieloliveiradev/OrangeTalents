package br.com.zup.orangetalents.orangetalents.veiculo;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.orangetalents.orangetalents.client.VeiculoClient;
import br.com.zup.orangetalents.orangetalents.client.VeiculoClientResponse;
import br.com.zup.orangetalents.orangetalents.usuario.Usuario;
import br.com.zup.orangetalents.orangetalents.usuario.UsuarioRepository;

@RestController
@RequestMapping("/usuarios/veiculos")
public class VeiculoController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private VeiculoClient client;

	@PostMapping("/{id}")
	public ResponseEntity<?> cadastrarVeiculo(@PathVariable Long id, @RequestBody @Valid VeiculoRequest request) {
		Optional<Usuario> possivelUsuario = usuarioRepository.findById(id);
		
		// 01 - Verifica se o usuario existe
		if(!possivelUsuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		// 02 - Consulta serviço/client
		Veiculo veiculo = consultarVeiculoClient(request, possivelUsuario.get());
		possivelUsuario.get().AdicionarVeiculo(veiculo);
		usuarioRepository.save(possivelUsuario.get());
		
		return ResponseEntity.ok().build();
	}
	
	
	public Veiculo consultarVeiculoClient(VeiculoRequest request, Usuario usuario) {
		try {
			VeiculoClientResponse veiculoClient = client.consultarVeiculo(request.getMarca(), request.getModelo(), request.getAno());
			Veiculo novoVeiculo = veiculoClient.paraVeiculo(usuario);
			return novoVeiculo;
		} catch (Exception e) {
			System.out.println("erro: " + e.getMessage());
		}
		return null;
	}
}
