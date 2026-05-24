package application;

import java.util.List;
import java.util.Scanner;

public class TelaDoTerminal {

	Scanner teclado = new Scanner(System.in);

	public int perguntarQuantidadeJogadores() {
		System.out.print("Enter the number os players: ");
		return Integer.parseInt(teclado.nextLine());
	}

	public String perguntarNome() {
		System.out.print("Enter your name: ");
		return teclado.nextLine();
	}

	public int perguntarPalpite(String nome) {
		System.out.printf("Player %s write your guess: ", nome);
		return Integer.parseInt(teclado.nextLine());
	}

	public void jogoPensando() {
		System.out.println("I'm thinking of number between 0 and 9\n");
	}

	public void palpiteEscolhido(String nome, int palpite) {
		System.out.printf("\nPlayer %s guessed %d%n\n ", nome, palpite);
	}

	public void anunciarVencedor(List<String> vencedores, int numeroEscolhido) {
		
		//O STRING.JOIN TRANSFORMA O [JOÃO, MARIA] EM "JOÃO, MARIA"
		String nomesFormatados = String.join(", ", vencedores);
		
		for(int i=0; i<50; i++) {
			System.out.println();
		}
		
		System.out.println("We have winner(s)!");
		System.out.println("The Winner(s): " + nomesFormatados);
		System.out.println("Number to guess is " + numeroEscolhido);
		System.out.println("Game is over.");
	}
	
	public void tentarNovamente() {
		System.out.println("\nPlayers will have to try again.");
	}
}
