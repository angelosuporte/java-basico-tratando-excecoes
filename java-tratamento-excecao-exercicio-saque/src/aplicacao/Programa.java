package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import modelo.entidades.Conta;
import modelo.excecoes.ExcecaoDeDominio;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Informe dos dados da conta ");
			System.out.print("Numero: ");
			Integer numero = sc.nextInt();
			sc.nextLine();
			System.out.print("Titular: ");
			String titular = sc.next();
			System.out.print("Saldo inicial: ");
			Double saldoInicial = sc.nextDouble();
			System.out.print("Limite de saque: ");
			Double limiteSaque = sc.nextDouble();
			Conta conta = new Conta(numero, titular, saldoInicial, limiteSaque);
			
			System.out.print("Infome a quantia para saque: ");
			Double saque = sc.nextDouble();
			conta.saque(saque);
			
			System.out.println(conta);
		} 
		catch(ExcecaoDeDominio e) {
			System.out.println("Saque não realizado: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro insperado");
		}
		
		sc.close();
	 
	}

}
