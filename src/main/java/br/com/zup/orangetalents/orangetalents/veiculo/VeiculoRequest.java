package br.com.zup.orangetalents.orangetalents.veiculo;

import javax.validation.constraints.NotBlank;

public class VeiculoRequest {

	@NotBlank
	private String marca;
	@NotBlank
	private String modelo;
	@NotBlank
	private String ano;
	
	public VeiculoRequest(@NotBlank String marca, @NotBlank String modelo, @NotBlank String ano) {
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
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
	
	
}
