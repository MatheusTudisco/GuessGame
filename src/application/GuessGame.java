package application;

public class GuessGame {

	/*O Guess Game tem três variáveis de 
	 * instância para os três objetos player
	 */
	
	Player p1;
	Player p2;
	Player p3;
	
	public void startGame() {
		
		/*Cria três objetos Player e os atribui às três 
		 * variáveis de instância Player.
		 */
		
		p1 = new Player();
		p2 = new Player();
		p3 = new Player();
		
		/*Declara três variáveis para armazenar os três 
		 * palpites feitos pelos jogadores.
		 */
		
		int guessp1 = 0;
		int guessp2 = 0;
		int guessp3 = 0;
		
		/*Declara três variáveis para armazenar um valor true or false 
		 * com base na resposta do jogador
		 */
		
		boolean P1isRight = false;
		boolean P2isRight = false;
		boolean P3isRight = false;
		
		/*Cria um número 'alvo' que os jogadores
		 * tem que adivinhar;
		 */
		
		int targetNumber = (int) (Math.random() * 10);
		System.out.println("I'm thinking of number between 0 and 9\n");
		
		while(true){

			//Chama o método guess() de cada jogador
			System.out.println("\nPlayer one, It's your turn\n");
			p1.guess();
			System.out.println("\nPlayer two, It's your turn\n");
			p2.guess();
			System.out.println("\nPlayer three, It's your turn\n");
			p3.guess();
			
			/*recebe o palpite de cada jogador (O resultao da execução do método guess())
			 * acessando a variável do palpite de cada jogador
			 */
			
			guessp1 = p1.number;
			System.out.println("\nPlayer one guessed " + guessp1);
			guessp2 = p2.number;
			System.out.println("\nPlayer two guessed " + guessp2);
			guessp3 = p3.number;
			System.out.println("\nPlayer three guessed " + guessp3);
			
			/*Verifica o palpite de cada ogador para ver se corresponde
			 * ao 'alvo'. Se um jogador acertar, define a variável desse
			 * jogador como verdadeira (lembre-se definimos como falsa
			 * por padrão
			 */
			
			if(guessp1 == targetNumber) {
				P1isRight = true;
			}
			if(guessp2 == targetNumber) {
				P2isRight = true;
			}
			if(guessp3 == targetNumber) {
				P3isRight = true;
			}
			
			/*Se o jogador um OU o jogador dois OU o jogador três acertar, gera um contador para
			 * mudar a mensagem de ganhadores, caso exista mais de um ele muda
			 */
			
			if(P1isRight || P2isRight || P3isRight) {
				
				int numberofWinners = 0;
				
				if(P1isRight) {
					numberofWinners++;
				}
				if(P2isRight) {
					numberofWinners++;
				}
				if(P3isRight) {
					numberofWinners++;
				}
				
				if(numberofWinners > 1) {
					System.out.println("\nWe have Winners!");
				} else {
					System.out.println("\nWe have a Winner!");
				}
				
				if(P1isRight) {
					System.out.println("\nPlayer 1 got it right! CONGRATULATIONS!\n");
				}
				if(P2isRight) {
					System.out.println("\nPlayer 2 got it right! CONGRATULATIONS!\n");
				}
				if(P3isRight) {
					System.out.println("\nPlayer 3 got it right! CONGRATULATIONS!\n");
				}
				System.out.println("\nNumber to guess is " + targetNumber);
				System.out.println("Game is over.");
				break; //Fim de jogo, acabou o loop
			} else {
				// Temos que continuar porque ninguém acertou!
				System.out.println("\nPlayers will have to try again.");
			}
		}
	}
}
