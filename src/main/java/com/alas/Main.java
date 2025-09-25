package com.alas;

import com.alas.board.Board;
import com.alas.util.Team;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();

        board.initializeBoard();
        board.printBoard();

        Team isTurnOfTeam = Team.WHITE; //the team that starts first
        int maxTurns = 100;
        int currentTurn = 1;
        while (currentTurn <= maxTurns) {
            System.out.println("\nTurn N°" + currentTurn + " of " + maxTurns);

            board.movePieceOnTurn(isTurnOfTeam);
            board.printBoard();

            currentTurn++; //end of turn
            if (isTurnOfTeam == Team.WHITE) {
                isTurnOfTeam = Team.BLACK;
            } else {
                isTurnOfTeam = Team.WHITE;
            }
        }
    }
}