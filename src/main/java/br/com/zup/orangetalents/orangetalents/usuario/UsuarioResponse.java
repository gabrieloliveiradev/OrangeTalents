package br.com.zup.orangetalents.orangetalents.usuario;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.zup.orangetalents.orangetalents.veiculo.VeiculoResponse;

public class UsuarioResponse {

	private String nome;
	private String email;
	private String cpf;
	private LocalDate dataNascimento;
	private List<VeiculoResponse> veiculos;
	
	public UsuarioResponse(Usuario usuario) {
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.cpf = usuario.getCpf();
		this.dataNascimento = usuario.getDataNascimento();
//		if(!usuario.getVeiculos().isEmpty()) {
//			
//		}
		this.veiculos = usuario.getVeiculos().stream().map(veiculo -> new VeiculoResponse(veiculo)).collect(Collectors.toList());
		//this.veiculos.addAll(usuario.getVeiculos().stream().map(VeiculoResponse::new).collect(Collectors.toList()));
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public List<VeiculoResponse> getVeiculos() {
		return veiculos;
	}
	
}
