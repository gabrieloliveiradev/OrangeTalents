package br.com.zup.orangetalents.orangetalents.veiculo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class VerificarRodizio {

	public static boolean consultarRodizio(Veiculo veiculo) {
		//Formatando data do sistesma
		LocalDate data = LocalDate.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		String dataAtual = formato.format(data);

		String rodizio = diaDaSemana(dataAtual);
		
		if(veiculo.getDiaRodizio().toString().contains(rodizio)) {
			return true;
		}
		return false;
	}
	
	//Método para pegar o dia da Semana
	public static String diaDaSemana(String data) {
	    DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/uuuu");
	    DayOfWeek dow = DayOfWeek.from(parser.parse(data));
	    return dow.getDisplayName(TextStyle.SHORT, new Locale("pt", "BR")).toUpperCase();
	}
}
