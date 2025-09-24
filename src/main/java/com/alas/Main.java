package com.alas;

import com.alas.board.Board;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();

        board.initializeBoard();
        board.printBoard();

        boolean isTurnOfTeam = true; //white team starts
        int maxTurns = 100;
        int currentTurn = 1;
        while (currentTurn <= maxTurns) {
            System.out.println("Turn N°" + currentTurn + " of " + maxTurns);

            board.movePieceOnTurn(isTurnOfTeam);
            board.printBoard();

            currentTurn++; //end of turn
            isTurnOfTeam = !isTurnOfTeam; //switch team turn
        }
    }
}