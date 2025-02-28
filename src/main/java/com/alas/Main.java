package com.alas;

import com.alas.board.Board;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();

        board.initializeBoard();
        board.printBoard();

        board.movePieceOnTurn(true); //white team
        board.printBoard();

        board.movePieceOnTurn(false); //black team
        board.printBoard();
    }
}