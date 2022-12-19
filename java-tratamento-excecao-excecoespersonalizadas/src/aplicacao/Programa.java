package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidades.Reservas;
import modelo.excecoes.ExcecaoDeDominio;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Numero do quarto: ");
			int numero = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy) ");
			Date checkIn = sdf.parse(sc.next()); // o sdf vai converter o dado inserido conforme mascara de formatacao
													// definida
			System.out.print("Check-out date (dd/MM/yyyy) ");
			Date checkOut = sdf.parse(sc.next());

			Reservas reservas = new Reservas(numero, checkIn, checkOut);
			System.out.println("Reservas: " + reservas);
			System.out.println();

			System.out.println("Informe as datas para atualizacao da reserva: ");
			System.out.print("Check-in date (dd/MM/yyyy) ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy) ");
			checkOut = sdf.parse(sc.next());

			reservas.updateDatas(checkIn, checkOut);
			System.out.println("Reservas: " + reservas);
		}
		catch(ParseException e) {
			System.out.println("Dado invalido");
		}
		
		catch(ExcecaoDeDominio e) { //Sera tratada caso ocorra erro nos dados no metodo updateDatas da classe Reservas 
			System.out.println("Erro na reserva " + e.getMessage());
		}
		
		catch(RuntimeException e) { //Tratamento de excecao generica
			System.out.println("Erro inesperado ");
		}

		sc.close();
	}

}
