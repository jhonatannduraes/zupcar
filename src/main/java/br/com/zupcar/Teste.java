package br.com.zupcar;

import java.time.DayOfWeek;
import java.time.OffsetDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String ano = "2019-3";
//		char numero = ano.charAt(3);
//			
//		if(numero == '9' || numero == '8') {
//			System.out.println("sexta-feira");
//		}
//		else if (numero == '7' || numero == '6') {
//			System.out.println("quinta-feira");
//		}
//		else if (numero == '5' || numero == '4') {
//			System.out.println("quarta-feira");
//		}
//		else if (numero == '3' || numero == '2') {
//			System.out.println("terça-feira");
//		}
//		else if (numero == '1' || numero == '0') {
//			System.out.println("segunda-feira");
//		} 
		
		String diaRodizio = "sexta-feira";
		Boolean ativo = false;
		String dataDeHoje = OffsetDateTime.now().getDayOfWeek().getDisplayName(TextStyle.FULL,
                Locale.getDefault());
		
			if(dataDeHoje.equals(diaRodizio)) {
				ativo = true;
			}
			System.out.println(ativo);
		
	}

}
