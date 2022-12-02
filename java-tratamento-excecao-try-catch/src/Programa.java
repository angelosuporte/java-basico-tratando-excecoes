import java.util.Scanner;

import java.util.InputMismatchException;


public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
	try {
		String[] vet = sc.nextLine().split(" ");
		int posicao = sc.nextInt();
		System.out.println(vet[posicao]);

	}
	catch(ArrayIndexOutOfBoundsException e) {
		System.out.println("Posicao invalida");
	}
	catch(InputMismatchException e) {
		System.out.println("Voce digitou um dado invalido. Digite apenas numeros inteiros");
	}
	System.out.println("Fim do programa");
	sc.close();
	}

}
