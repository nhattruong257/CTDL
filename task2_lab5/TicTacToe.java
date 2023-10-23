package task2_lab5;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };
        
        char currentPlayer = 'X';
        boolean isGameFinished = false;
        
        while (true) {
            printBoard(board);
            
            int[] move = getPlayerMove(currentPlayer);
            int row = move[0];
            int col = move[1];
            
            if (board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                
                if (checkWin(board, currentPlayer)) {
                    printBoard(board);
                    System.out.println(currentPlayer + " wins! Congratulations!");
                    isGameFinished = true;
                } else if (isBoardFull(board)) {
                    printBoard(board);
                    System.out.println("It's a draw!");
                    isGameFinished = true;
                }
                
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("That cell is already occupied. Try again.");
            }
            
            if (isGameFinished) {
                break;
            }
        }
    }
    
    public static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }
    
    public static int[] getPlayerMove(char currentPlayer) {
        Scanner scanner = new Scanner(System.in);
        int[] move = new int[2];
        
        System.out.print("Player " + currentPlayer + ", enter your move (row and column): ");
        move[0] = scanner.nextInt();
        move[1] = scanner.nextInt();
        
        return move;
    }
    
    public static boolean checkWin(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }
    
    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                	return false;
                }
            }
        }
        return true;
    }
}