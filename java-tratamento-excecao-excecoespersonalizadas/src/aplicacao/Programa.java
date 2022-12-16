package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidades.Reservas;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Numero do quarto: ");
		int numero = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy) ");
		Date checkIn = sdf.parse(sc.next()); //o sdf vai converter o dado inserido conforme mascara de formatacao definida
		System.out.print("Check-out date (dd/MM/yyyy) ");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: A data do checkOut deve ser depois da data o checkIn");
		}
		else {
			Reservas reservas = new Reservas(numero, checkIn, checkOut);
			System.out.println("Reservas: " + reservas);
			System.out.println();
			
			System.out.println("Informe as datas para atualizacao da reserva: ");
			System.out.print("Check-in date (dd/MM/yyyy) ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy) ");
			checkOut = sdf.parse(sc.next());
		
			Date agora = new Date(); //Vai pegar o instante atual
			if(checkIn.before(agora) || checkOut.before(agora)) {
				System.out.println("Erro na reserva: A atualizacao da reserva deve ser com data futura");
			}
			else if(!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva: A data do checkOut deve ser depois da data o checkIn");
			}
			else {
				reservas.updateDatas(checkIn, checkOut);
				System.out.println("Reservas: " + reservas);
			}
		}
		
		sc.close();
	}

}
