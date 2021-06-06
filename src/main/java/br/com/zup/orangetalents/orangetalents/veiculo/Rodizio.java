package br.com.zup.orangetalents.orangetalents.veiculo;

public enum Rodizio {
	SEGUNDA_FEIRA,
	TERCA_FEIRA,
	QUARTA_FEITA,
	QUINTA_FEIRA,
	SEXTA_FEIRA;
	
	public static Rodizio verDia(String ano) {
		int ultimoDigito = Integer.parseInt(ano.substring(ano.length() - 1));
		
		switch (ultimoDigito) {
		case 0:
		case 1:
			return SEGUNDA_FEIRA;
		case 2:
		case 3:
			return TERCA_FEIRA;
		case 4:
		case 5:
			return QUARTA_FEITA;
		case 6:
		case 7:
			return QUINTA_FEIRA;
		case 8:
		case 9:
			return SEXTA_FEIRA;
		default:
			break;
		}
		return null;
	}
}
