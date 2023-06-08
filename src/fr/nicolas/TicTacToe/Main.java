package fr.nicolas.TicTacToe;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static String[][] board = { { " ", " ", " " }, { " ", " ", " " }, { " ", " ", " " }, };

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
}