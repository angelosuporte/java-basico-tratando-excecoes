import java.util.InputMismatchException;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		
		metodoInicial();
		System.out.println("Fim do programa");
	}
		
	
	public static void metodoInicial() {
		System.out.println("Comecou o metodo inicial");
		metodoInvocado();
		System.out.println("Fim metodo inicial");
	}
	public static void metodoInvocado() {
		System.out.println("Comecou o metodo Invocado");
        Scanner sc = new Scanner(System.in);
		
		try {
			String[] vet = sc.nextLine().split(" ");
			int posicao = sc.nextInt();
			System.out.println(vet[posicao]);

		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Posicao invalida");
			e.printStackTrace();//<---Nos ajuda rastrear os pontos relacionados com a excecao
			sc.next();//<-----espera voce digitar alguma coisa
			
		}
		catch(InputMismatchException e) {
			System.out.println("Voce digitou um dado invalido. Digite apenas numeros inteiros");
		}
		
		sc.close();

		System.out.println("Fim do metodo Invocado");
	}

}
