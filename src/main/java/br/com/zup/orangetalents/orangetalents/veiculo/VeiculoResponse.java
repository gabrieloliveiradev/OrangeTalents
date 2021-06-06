package br.com.zup.orangetalents.orangetalents.veiculo;

public class VeiculoResponse {

	private String marca;
	private String modelo;
	private String ano;
	private boolean rodizioStatus;
	
	public VeiculoResponse(Veiculo veiculo) {
		this.marca = veiculo.getMarca();
		this.modelo = veiculo.getModelo();
		this.ano = veiculo.getAno();
		this.rodizioStatus = VerificarRodizio.consultarRodizio(veiculo);
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

	public boolean isRodizioStatus() {
		return rodizioStatus;
	}
	
}
