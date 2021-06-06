package br.com.zup.orangetalents.orangetalents.usuario;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zup.orangetalents.orangetalents.veiculo.Veiculo;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
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
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.MERGE)
	private List<Veiculo> veiculos; 
	
	public Usuario(String nome, String email, String cpf, LocalDate dataNascimento) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}
	
	@Deprecated //Para uso do hibernate
	public Usuario() {}

	public Long getId() {
		return id;
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

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}
	
	public void AdicionarVeiculo(Veiculo veiculo) {
		this.veiculos.add(veiculo);
	}
	
}
