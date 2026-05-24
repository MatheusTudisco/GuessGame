package application;

import java.util.ArrayList;
import java.util.List;

public class GuessGame {

	TelaDoTerminal terminal = new TelaDoTerminal();
	GameMath gameMath = new GameMath();

	public void startGame() {
		
		int quantidadeJogadores = terminal.perguntarQuantidadeJogadores();

		// Cria a List vazia
		List<Player> players = new ArrayList<>();

		/*
		 * Gera um loop para criar quantos jogadores foram digitados e salva seus
		 * nomes.
		 */

		for (int i = 0; i < quantidadeJogadores; i++) {
			String nomeDigitado = terminal.perguntarNome();
			players.add(i, new Player(nomeDigitado));
		}
		
		gameMath.sortearNumero();
		terminal.jogoPensando();
		System.out.println(gameMath.getTargetNumber());

		/*
		 * Cria a váriavel boolean que será utilizada em forma de controle para
		 * finalizar ou continuar o jogo
		 */
		
		boolean jogoAcabou = false;
		while (jogoAcabou == false) {

			// Criação do loop para acessar o Arraylist
			for (int i = 0; i < quantidadeJogadores; i++) {

				int palpiteDigitado = terminal.perguntarPalpite(players.get(i).getNome());
				players.get(i).setNumber(palpiteDigitado);

				terminal.palpiteEscolhido(players.get(i).getNome(), players.get(i).getNumber());
			}
			
			List<String> vencedores = new ArrayList<String>();
			
			for(int i=0; i<quantidadeJogadores; i++) {
				
				gameMath.verificarPalpite(players.get(i).getNumber());
				
				//VERIFICA QUEM ACERTOU
				if(gameMath.getPalpiteVerificado()) {
					
					//ADICIONA QUEM ACERTOU NA LISTA DE VENCEDORES
					vencedores.add(players.get(i).getNome());
					jogoAcabou = true;
				}
			}
			
			/*
			 * Verifica a variável 'jogoAcabou', se ela for TRUE executa o IF e chama o método
			 * anunciarVencedor(), caso for FALSE executa o ELSE e chama o
			 * metodo tentarNovamente().
			 */
			if (jogoAcabou == true) {

				terminal.anunciarVencedor(vencedores, gameMath.getTargetNumber());
				
			} else {
				terminal.tentarNovamente();
			}
		}
	}
}
