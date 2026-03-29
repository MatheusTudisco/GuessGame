package application;

import java.util.Scanner;

public class Player {
	
	Scanner kb = new Scanner(System.in);
	
	int number = 0;
	
	public void guess() {
		System.out.print("Write your guess: ");
		number = kb.nextInt();
	}
}
