package br.com.zup.orangetalents.orangetalents.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Boolean existsByEmail(String email);
	
	Boolean existsByCpf(String cpf);
}
