package application;
import java.util.ArrayList;
import java.util.Scanner;

public class GuessGame {

	public void startGame() {
		/*Instância a variável Scanner, cria a váriavel que
		 * armazena o digitado pelo usuário
		 */
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter the number os players: ");
		int playerCount = kb.nextInt();
		
		/*Cria a ArrayList vazia*/
		ArrayList<Player> players = new ArrayList<>();
		
		/*Gera um loop para criar quantos jogadores
		 * foram digitados
		 */
		for(int i=0;i<playerCount; i++) {
			players.add(new Player());
		}
		
		/*Cria um número 'alvo' que os jogadores
		 * tem que adivinhar;
		 */	
		int targetNumber = (int) (Math.random() * 10);
		System.out.println("I'm thinking of number between 0 and 9\n");
		
		/*Cria a váriavel boolean que será utilizada em forma
		 * de controle para finalizar ou continuar o jogo
		 */
		Boolean jogoAcabou = false;
		while(jogoAcabou == false){
			
			/*Cria um ArrayList guessPLayers para 
			 * armazenar o método guess() de cada jogador
			 */
			ArrayList<Integer> guessPlayers = new ArrayList<>();
			
			//Criação do loop para acessar o Arraylist guessPlayers
			for(int i=0;i<playerCount; i++) {
				
			//Chama o método guess() de cada jogador instânciado
			System.out.printf("\nPlayer %d, It's your turn%n", i+1);
			players.get(i).guess();
			
			//Armazena o resultado do método guess de cada player na lista guessPlayers
			guessPlayers.add(players.get(i).number);
			System.out.printf("\nPlayer %d guessed %d%n ", i+1, guessPlayers.get(i));
			}
			
			/*Criação do ArrayList que armazena se o jogador acertou ou
			 * errou o palpite.*/
			ArrayList<Boolean>playerIsRight = new ArrayList<>();
			
			/*Loop para acessar o ArrayList guessPlayers e comparar
			 * se o palpite do jogador está correto, caso esteja correto
			 * se adiciona o valor True a ArrayList playerIsRight
			 * Não necessita uso de índice pois o método add() utiliza por padrão 
			 * um comportamento de "fila indiana", ele sempre joga a nova informação
			 * na próxima gaveta vazia.*/
			for(int i=0; i<playerCount; i++) {		
			if(guessPlayers.get(i) == targetNumber) {
				playerIsRight.add(Boolean.TRUE);
			}else{
				playerIsRight.add(Boolean.FALSE);
			}
		}
			/*Verifica se cada jogador acertou o palpite,
			 * verificando por índice, se o valor for True ele habilita IF
			 * e imprime na tela o vencedor e atribui para a variável 
			 * 'jogoAcabou' o valor TRUE.*/
			for(int i=0; i<playerCount; i++) {				
			if(playerIsRight.get(i) == true) {
				System.out.printf("%nThe winner is Player %d%n", i+1);
				jogoAcabou = true;
			}
		}
			/*Verifica a variável 'jogoAcabou', se ela for TRUE executa
			 * o IF e imprime na tela as mensagens de ganhadores,
			 * caso for FALSE executa o ELSE e imprime a mensagem de
			 * tentar novamente.*/
			if (jogoAcabou == true) 
			{
				System.out.println("\nWe have winner!\n");
				System.out.println("Number to guess is " + targetNumber);
				System.out.println("Game is over.");
				} else {
					System.out.println("\nPlayers will have to try again.");
				}
		}
	kb.close();//Encerra a variável 'kb' do Scanner.
	}
}

