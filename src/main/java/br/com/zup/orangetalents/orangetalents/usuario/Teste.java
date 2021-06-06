package br.com.zup.orangetalents.orangetalents.usuario;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class Teste {

	public static void main(String[] args) {
		
		LocalDate data = LocalDate.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		String dataAtual = formato.format(data);
		System.out.println(diaDaSemana(dataAtual));

	}
	
	public static String diaDaSemana(String data) {
	    DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/uuuu");
	    DayOfWeek dow = DayOfWeek.from(parser.parse(data));
	    return dow.getDisplayName(TextStyle.SHORT, new Locale("pt", "BR")).toUpperCase();
	}

}
