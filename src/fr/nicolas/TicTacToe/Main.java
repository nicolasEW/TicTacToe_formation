package fr.nicolas.TicTacToe;

import java.util.Scanner;
import java.util.Random;

public class Main {
	public static int availableCase = 9;
	public static String[][] board = { { " ", " ", " " }, { " ", " ", " " }, { " ", " ", " " }, };
	public static Scanner scanner = new Scanner(System.in);
	public static boolean turnO = true;

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
			String choice = scanner.nextLine();
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

		display();
		while (!checkWin() && availableCase > 0) {
			if (turnO) {
				play();
			} else {
				System.out.println("au tour du robot : ");
				bot();
			}
			turnO = !turnO;
			display();
		}

		if (checkWin()) {
			System.out.println("Bien jouer !");
		} else {
			System.out.println("Egaliter !");
		}
	}

	/**
	 * Affiche le tableau "board" dans la console
	 */
	public static void display() {
		String[] letters = { "A", "B", "C" };
		System.out.println("   1 2 3");
		
		for (int i = 0; i < board.length; i++) {
			System.out.println(letters[i] + " |" + board[i][0] + "|" + board[i][1] + "|" + board[i][2] + "|");
		}
	}

	/**
	 * Propose à l'utilisateur de jouer une case
	 */
	public static void play() {
		System.out.println("Veuillez indiquer une case :");

		String choice = scanner.nextLine();
		
		// LIGNE
		String lineText = choice.substring(0, 1);
		int line = 0;

		if (!lineText.equals("A") && !lineText.equals("B") && !lineText.equals("C")) {
			System.out.println("Ligne incorrect");
			play();
			return;
		}
		
		// if (lineText == "B") {
		if (lineText.equals("B")) {
			line = 1;
		} else if (lineText.equals("C")) {
			line = 2;
		}

		// COLUMN
		String columnText = choice.substring(1, 2);
		int column = 0;
		
		try {
			column = Integer.parseInt(columnText) - 1;
			if (column > 2 || column < 0) {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("Colonne incorrect");
			play();
			return;
		}
		
		

		if (board[line][column] == " ") {
			// board[line][column] = turnO ? "O" : "X";
			if (turnO) {
				board[line][column] = "O";
			} else {
				board[line][column] = "X";
			}
			availableCase--;
		} else {
			System.out.println("Case deja utilisé");
			play();
		}
	}
	
	/**
	 * Vérifie la victoire dans le tableau "board"
	 * 
	 * @return vraie si quelqu'un à gagner, faux si personne n'à gagner
	 */
	public static boolean checkWin() {
		for (int i = 0; i < board.length; i++) {
			if (board[i][0] != " " && board[i][0] == board[i][1] && board[i][0] == board[i][2]
					|| board[0][i] != " " && board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
				return true;
			}
		}
		if (board[0][0] != " " && board[0][0] == board[1][1] && board[0][0] == board[2][2]
				|| board[0][2] != " " && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
			return true;
		}

		return false;
	}
	
	/**
	 * Fait jouer le second joueur automatiquement
	 */
	public static void bot() {
		Random rand = new Random();
		int choice = rand.nextInt(availableCase) + 1;
		int index = 0; // index
		
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[x].length; y++) {
				if (board[x][y] == " ") {
					index++;
				}
				if (index == choice) {
					board[x][y] = "X";
					return;
				}
			}
		}
	}
}