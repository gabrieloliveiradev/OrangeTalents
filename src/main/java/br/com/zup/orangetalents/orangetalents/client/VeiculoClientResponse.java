package br.com.zup.orangetalents.orangetalents.client;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zup.orangetalents.orangetalents.usuario.Usuario;
import br.com.zup.orangetalents.orangetalents.veiculo.Veiculo;

public class VeiculoClientResponse {

	@JsonProperty("Valor")
	private String valor;

	@JsonProperty("Marca")
	private String marca;

	@JsonProperty("Modelo")
	private String modelo;

	@JsonProperty("AnoModelo")
	private String anoModelo;

	public Veiculo paraVeiculo(Usuario usuario) {
		return new Veiculo(marca, modelo, anoModelo, valor, usuario);
	}
	
}
