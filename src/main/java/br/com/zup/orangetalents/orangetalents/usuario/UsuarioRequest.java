package br.com.zup.orangetalents.orangetalents.usuario;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UsuarioRequest {

	@NotBlank
	private String nome;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	@CPF
	private String cpf;
	@JsonFormat(pattern="dd/MM/yyyy")
	@NotNull
	private LocalDate dataNascimento;
	
	public UsuarioRequest(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @CPF String cpf,
			@NotNull LocalDate dataNascimento) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
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
	
	public Usuario paraUsuario() { //Método para converter a requisição para a entidade Usuario
		return new Usuario(nome, email, cpf, dataNascimento);
	}
	
}
