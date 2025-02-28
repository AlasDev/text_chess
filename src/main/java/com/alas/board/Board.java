package com.alas.board;

import com.alas.pieces.*;
import com.alas.util.BasicChessPiece;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Board {
    //board[vertical][horizontal]
    public BoardSquare[][] board = new BoardSquare[8][8];

    /**
     * Reset the whole board and places all pieces of both teams on their starting positions
     */
    public void initializeBoard() {
        wipeBoard();

        resetTeamPieces(true); //white team
        resetTeamPieces(false); //black team

        refreshTiles();
        System.out.println("Board initialized");
    }

    /**
     * Places all chess pieces from both teams on their starting positions.
     * @param team 'true' is white, 'false' is black
     */
    private void resetTeamPieces(Boolean team) {
        int i, j; //indicates rows -> i is back, j is front
        if (team) { //white
            j = 6;
            i = 7;
        } else { //black
            i = 0;
            j = 1;
        }
        //front row
        board[j][0].setChessPiece(new Pawn(team));
        board[j][1].setChessPiece(new Pawn(team));
        board[j][2].setChessPiece(new Pawn(team));
        board[j][3].setChessPiece(new Pawn(team));
        board[j][4].setChessPiece(new Pawn(team));
        board[j][5].setChessPiece(new Pawn(team));
        board[j][6].setChessPiece(new Pawn(team));
        board[j][7].setChessPiece(new Pawn(team));
        //back row
        board[i][0].setChessPiece(new Rook(team));
        board[i][1].setChessPiece(new Knight(team));
        board[i][2].setChessPiece(new Bishop(team));
        board[i][3].setChessPiece(new King(team));
        board[i][4].setChessPiece(new Queen(team));
        board[i][5].setChessPiece(new Bishop(team));
        board[i][6].setChessPiece(new Knight(team));
        board[i][7].setChessPiece(new Rook(team));
    }

    /**
     * Prints the whole board and also adds numbers on borders to help figure out coords of things
     */
    public void printBoard() {
        int vertical = 0;
        int horizontal = 0;
        for(int i = 0; i < board[0].length; i++){
            for(int j = 0; j < board[1].length; j++){
                System.out.print("[" + board[i][j].getIcon() + "]");
            }
            System.out.println("(" + vertical + ")");
            vertical++;
        }
        for(int k = 0; k < 8; k++){
            System.out.print("(" + horizontal + ")");
            horizontal++;
        }
    }

    /**
     * Wipes clean the whole board (all chess pieces will be erased and tiles refreshed)
     */
    public void wipeBoard(){
        boolean color = false;
        for(int i = 0; i < board[0].length; i++){
            color = !color;
            for(int j = 0; j < board[1].length; j++){
                color = !color;
                board[i][j] = new BoardSquare(null);
                board[i][j].setIcon(color);
            }
        }
    }

    /**
     * Refreshes all the tile colors
     */
    public void refreshTiles(){
        boolean color = false;
        for(int i = 0; i < board[0].length; i++){
            color = !color;
            for(int j = 0; j < board[1].length; j++){
                color = !color;
                if(board[i][j].getChessPiece() != null) {
                    board[i][j].refreshIcon();
                }
            }
        }
    }

    /**
     * Refreshes tile color of a single tile
     * @param coords coordinates of theBoardSquare you want to refresh
     */
    public void refreshTiles(int[] coords){
        board[coords[0]][coords[1]].refreshIcon();
    }

    /**
     * @param piece instance of the chess piece you want to know the location of
     * @return coords in the table
     */
    public int[] getCoordsOfPiece(BasicChessPiece piece) {
        for (int i=0; i < this.board[0].length; i++) {
            for (int j=0; j < this.board[1].length; j++) {
                if (this.board[i][j].getChessPiece() == piece) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public BoardSquare getBoardSquare(int[] coords) {
        return board[coords[0]][coords[1]];
    }

    public void setBoardSquare(int[] coords, BasicChessPiece chessPiece) {
        board[coords[0]][coords[1]].setChessPiece(chessPiece);
    }

    /**
     * Searches for all pieces that are of a certain team and also tell you their location.
     * @param team 'white' if true, 'black' if false
     * @return list of all the pieces of that team and their individual coords on the board
     */
    public List<String> getListOfPiecesOfTeam(Boolean team) {
        List<String> piecesList = new ArrayList<>(); //list of all pieces and their location

        for (int i=0; i < this.board.length; i++) {
            for (int j=0; j < this.board[0].length; j++) {
                if (this.board[i][j].getChessPiece() != null && this.board[i][j].getChessPiece().getTeam() == team) {
                    int[] pieceCoords = {i, j};
                    piecesList.add(this.board[i][j].getChessPiece().getIcon() + " at '" + Arrays.toString(pieceCoords) + "'.");
                }
            }
        }
        return piecesList;
    }

    /**
     * Method to ask the player to make a move.
     * @param team 'white' if true, 'black' if false.
     */
    public void movePieceOnTurn(Boolean team) {
        String teamName;
        if (team) {
            teamName = "White";
        } else {
            teamName = "Black";
        }

        int[] from = new int[2];
        int[] to = new int[2];

        System.out.println("\nTeam '" + teamName + "' turn. Make a move!");

        System.out.println("These are the pieces of your team: ");
        getListOfPiecesOfTeam(team).forEach(System.out::println);

        System.out.println("Enter the coordinates of the piece you wish to move: ");
        Scanner scanner = new Scanner(System.in);

        boolean searchingFrom = true;
        while (searchingFrom) { //loops until a valid pair of coords with a valid piece in them is found
            System.out.println("From vertical: ");
            from[0] = scanner.nextInt();
            System.out.println("From horizontal: ");
            from[1] = scanner.nextInt();

            if (getBoardSquare(from).getChessPiece() != null && getBoardSquare(from).getChessPiece().getTeam() == team) {
                searchingFrom = false; //suitable starting position was found, end loop
                System.out.println("Piece selected: " + getBoardSquare(from).getIcon() + " at '" + Arrays.toString(from) + "'.");
            } else {
                System.out.println("Invalid Move! You can only move pieces of your team!");
            }
        }

        System.out.println("Enter the coordinates of where you want to move it: ");

        boolean searchingTo = true;
        while (searchingTo) { //loops until a valid pair of coords is found
            System.out.println("To vertical: ");
            to[0] = scanner.nextInt();
            System.out.println("To horizontal: ");
            to[1] = scanner.nextInt();

            //if boardSquare is empty or piece in it is not an ally
            if (getBoardSquare(to).getChessPiece() == null || getBoardSquare(to).getChessPiece().getTeam() != team) {
                searchingTo = false; //suitable destination was found, end loop
                //scanner.close();
                move(from, to);
            } else {
                System.out.println("Invalid Move! Insert the coords of a valid position!");
            }
        }
        refreshTiles();
    }

    /**
     * Method to move an object of type BasicChessPiece from one place to the other
     * @param from starting coords of the piece you want to move
     * @param to coords of where you want the piece to go
     */
    public void move(int[] from, int[] to) {
        getBoardSquare(to).setChessPiece(getBoardSquare(from).getChessPiece());
        getBoardSquare(from).setChessPiece(null);
        String message = String.format("Moved '%s' from '%s' to '%s'.", getBoardSquare(to).getChessPiece().getIcon(), Arrays.toString(from), Arrays.toString(to));
        System.out.println(message);
    }
}
