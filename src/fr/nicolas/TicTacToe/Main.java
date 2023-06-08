package fr.nicolas.TicTacToe;

import java.util.Scanner;

public class Main {
	public static String[][] board = { { " ", " ", " " }, { " ", " ", " " }, { " ", " ", " " }, };
	public static Scanner scanner = new Scanner(System.in);
	public static boolean turnX = true;
	public static int availableCase = 9;

	public static void main(String[] args) {
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
			if (turnX) {
				board[line][column] = "X";
			} else {
				board[line][column] = "O";
			}
			availableCase--;
		} else {
			System.out.println("Case deja utilisé");
			play();
		}
	}
}