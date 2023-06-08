package fr.nicolas.TicTacToe;
import java.util.Scanner;

public class Main {
	public static Scanner scan = new Scanner(System.in);
	public static String[][] board = { { " ", " ", " " }, { " ", " ", " " }, { " ", " ", " " }, };
	public static boolean turnO = true;
	public static int availableCase = 9;

	/**
	 * Relance la fonction startGame jusqu'à ce que le joueur décide d'arreter de
	 * jouer
	 * 
	 * @param args n'est pas utilisé
	 */
	public static void main(String[] args) {
		System.out.println("Bienvenue au TicTacToe !");
		boolean retry = false;

		do {
			startGame();
			System.out.println("Voulez vous rejouer ?  o : oui  -  n : non");
			String choice = scan.nextLine();
			if (choice.equals("o") || choice.equals("oui")) {
				retry = true;
			} else {
				retry = false;
			}
		} while (retry);

		System.out.println("Au revoir");
	}

	/**
	 * Permet de lancer le jeu TicTacToe Contient le cycle de vie du jeu
	 */
	public static void startGame() {
		for (int line = 0; line < board.length; line++) {
			for (int column = 0; column < board.length; column++) {
				board[line][column] = " ";
			}
		}
		turnO = true;
		availableCase = 9;

		afficher();
		while (!checkWin() && availableCase > 0) {
			if (turnO) {
				jouer();
			} else {
				System.out.println("au tour du robot : ");
				bot();
			}
			turnO = !turnO;
			afficher();
		}

		if (checkWin()) {
			System.out.println("Bien jouer !");
		} else {
			System.out.println("Egaliter !");
		}
	}

	public static boolean checkWin() {
		return true;
	}

	public static void afficher() {

	}

	public static void jouer() {

	}
	
	public static void bot() {

	}
}