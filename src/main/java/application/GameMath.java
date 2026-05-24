package application;

public class GameMath {

	private int targetNumber;
	private boolean palpiteVerificado;

	public void sortearNumero() {
		/*
		 * Cria um número 'alvo' que os jogadores tem que adivinhar;
		 */
		targetNumber = (int) (Math.random() * 10);
	}

	public int getTargetNumber() {
		return targetNumber;
	}

	public boolean verificarPalpite(int palpite) {
		if (palpite == targetNumber) {
			return palpiteVerificado = true;
		} else {
			return palpiteVerificado = false;
		}
	}

	public boolean getPalpiteVerificado() {
		return palpiteVerificado;
	}
}
