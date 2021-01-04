package com.company;
import java.util.*;

public class Main {

    final static int emptySpace = 0;
    final static int enoughToWin = 4;
    //you will have an option to choose where to render a response
    public static void renderBoard(int[][] rows){
        for(int i = 0; i < rows.length; i++) {
            StringBuilder row = new StringBuilder();
            for(int j = 0; j < rows[i].length; j++) {
                row.append(String.format("%s  ", rows[i][j]));
            }
            System.out.println(row);
        }
    }

    public static void resolveWinnerHV(int[][] board) {
        System.out.printf("Player %s is the winner!%n", board[0][0]);
    }

    public static boolean horizontalCheck(int[][] board) {
        int counter = 0;
        boolean hasWinner = false;
        for (int currentRow = 0; currentRow < board.length; currentRow++) {
            int winner = 0;
            for(int currentColumn = 0; currentColumn < board.length - 1; currentColumn++) {
                if(board[currentRow][currentColumn] == emptySpace) {
                    counter = 0;
                    break;
                }

                if(board[currentRow][currentColumn] == board[currentRow][currentColumn+1]) {
                    winner = board[currentRow][currentColumn];
                    counter++;
                } else {
                    counter = 0;
                }

                if(counter == enoughToWin) {
                    System.out.printf("Player %s is the winner!%n", winner);
                    hasWinner = true;
                }
            }
        }
        return hasWinner;
    }

    public static boolean verticalCheck(int[][] board) {
        int counter = 0;
        boolean hasWinner = false;
        for (int currentColumn = 0; currentColumn < board.length; currentColumn++) {
            int winner = 0;
            for(int currentRow = 0; currentRow < board.length - 1; currentRow++) {
                if(board[currentRow][currentColumn] == emptySpace) {
                    counter = 0;
                    break;
                }

                if(board[currentRow][currentColumn] == board[currentRow+1][currentColumn]) {
                    winner = board[currentRow][currentColumn];
                    counter++;
                } else {
                    counter = 0;
                }

                if(counter == enoughToWin) {
                    System.out.printf("Player %s is the winner!%n", winner);
                    hasWinner = true;
                }
            }
        }
        return hasWinner;
    }

    public static int diagonalCheck(int[][] board) {

    }

    public static boolean hasWinner(int[][] board) {
        // if vertical check or horizontal check... because check from same point... diagonal will have to check two points
        return verticalCheck(board) || horizontalCheck(board);
    }

    public static void playerTurn(int[][] rows, int player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose the column");
        int column = Integer.parseInt(scanner.nextLine());
        System.out.println("Choose the row");
        int row = Integer.parseInt(scanner.nextLine());

       rows[row-1][column-1] = player;
    }

    public static void main(String[] args) {
        int[] row1 = { 0, 0, 0, 0, 0 };
        int[] row2 = { 0, 0, 0, 0, 0 };
        int[] row3 = { 0, 0, 0, 0, 0 };
        int[] row4 = { 0, 0, 0, 0, 0 };
        int[] row5 = { 0, 0, 0, 0, 0 };
        int[][] boardRepresentation = { row1, row2, row3, row4, row5 };
        int player = 1;
        while(!hasWinner(boardRepresentation)){
            playerTurn(boardRepresentation, player);
            renderBoard(boardRepresentation);
            if(player == 1) {
                player = 2;
            } else {
                player = 1;
            }
        }
    }
}
