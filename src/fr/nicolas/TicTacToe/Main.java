package fr.nicolas.TicTacToe;
import java.util.Random;
public class Main {
	public static int availableCase = 9;
	public static String[][] board = { { " ", " ", " " }, { " ", " ", " " }, { " ", " ", " " }, };

	public static void main(String[] args) {}
	
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