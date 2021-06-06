package br.com.zup.orangetalents.orangetalents.veiculo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import br.com.zup.orangetalents.orangetalents.usuario.Usuario;

@Entity
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String marca;
	@NotBlank
	private String modelo;
	@NotBlank
	private String ano;
	@NotBlank
	private String valor;
	@Enumerated(value = EnumType.STRING)
	private Rodizio diaRodizio;
	@ManyToOne
	private Usuario usuario;
	
	public Veiculo(String marca, String modelo, String ano, String valor, Usuario usuario) {
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.valor = valor;
		this.usuario = usuario;
		this.diaRodizio = Rodizio.verDia(ano);
	}
	
	@Deprecated
	public Veiculo() {}

	public Long getId() {
		return id;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getAno() {
		return ano;
	}

	public String getValor() {
		return valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Rodizio getDiaRodizio() {
		return diaRodizio;
	}
	
}
