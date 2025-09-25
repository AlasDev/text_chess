package com.alas.board;

import com.alas.moves.Move;
import com.alas.pieces.*;
import com.alas.util.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Board {
    public static final int BOARD_SIZE = 8;
    public BoardSquare[][] board = new BoardSquare[BOARD_SIZE][BOARD_SIZE]; //board[vertical][horizontal]

    private final Move moveHelper = new Move(this);
    final Scanner scanner = new Scanner(System.in);
    /**
     * Reset the whole board and places all pieces of both teams in their starting positions
     */
    public void initializeBoard() {
        wipeBoard();

        resetTeamPieces(Team.WHITE); //reset the white team
        resetTeamPieces(Team.BLACK); //reset the black team

        refreshBoardSquareDisplayedIcon();
        //System.out.println("Board initialized");
    }

    /**
     * Places all chess pieces from both teams on their starting positions.
     * @param team 'WHITE' is white, 'BLACK' is black
     */
    private void resetTeamPieces(Team team) {
        Integer backRow = null;
        Integer frontRow = null;
        if (team == Team.WHITE) {
            frontRow = 6;
            backRow = 7;
        } else if (team == Team.BLACK) {
            backRow = 0;
            frontRow = 1;
        }

        if (frontRow != null) {
            //front row
            board[frontRow][0].setChessPiece(new Pawn(team));
            board[frontRow][1].setChessPiece(new Pawn(team));
            board[frontRow][2].setChessPiece(new Pawn(team));
            board[frontRow][3].setChessPiece(new Pawn(team));
            board[frontRow][4].setChessPiece(new Pawn(team));
            board[frontRow][5].setChessPiece(new Pawn(team));
            board[frontRow][6].setChessPiece(new Pawn(team));
            board[frontRow][7].setChessPiece(new Pawn(team));
        }
        if (backRow != null) {
            //back row
            board[backRow][0].setChessPiece(new Rook(team));
            board[backRow][1].setChessPiece(new Knight(team));
            board[backRow][2].setChessPiece(new Bishop(team));
            board[backRow][3].setChessPiece(new King(team));
            board[backRow][4].setChessPiece(new Queen(team));
            board[backRow][5].setChessPiece(new Bishop(team));
            board[backRow][6].setChessPiece(new Knight(team));
            board[backRow][7].setChessPiece(new Rook(team));
        }
    }

    /**
     * Prints the whole board and also adds numbers on borders to help figure out coords of things
     */
    public void printBoard() {
        refreshBoardSquareDisplayedIcon();
        int vertical = 0;
        int horizontal = 0;
        for(int i = 0; i < board[0].length; i++){
            for(int j = 0; j < board[1].length; j++){
                System.out.print("[" + board[i][j].getDisplayedIcon() + "]");
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
                board[i][j].setTileColor(color);
            }
        }
    }

    /**
     * Refreshes all the tile colors
     */
    public void refreshBoardSquareDisplayedIcon(){
        for(int i = 0; i < board[0].length; i++){
            for(int j = 0; j < board[1].length; j++){
                board[i][j].refreshDisplayedIcon();
            }
        }
    }

    public BoardSquare getBoardSquare(int[] coords) {
        return board[coords[0]][coords[1]];
    }

    /**
     * Searches for all pieces that are of a certain team and also tell you their location.
     * @param team 'white' if true, 'black' if false
     * @return list of all the pieces of that team and their individual coords on the board
     */
    public List<String> getListOfPiecesOfTeam(Team team) {
        List<String> piecesList = new ArrayList<>(); //list of all pieces and their location

        for (int i=0; i < this.board.length; i++) {
            for (int j=0; j < this.board[0].length; j++) {
                if (this.board[i][j].getChessPiece() != null && this.board[i][j].getChessPiece().getTeam() == team) {
                    int[] pieceCoords = {i, j};
                    piecesList.add(this.board[i][j].getChessPiece().getIcon().getIcon() + " at '" + Arrays.toString(pieceCoords) + "'.");
                }
            }
        }
        return piecesList;
    }

    /**
     * Checks if the coords exist in the board.
     * @param coords coords you want to check
     * @return 'true' if they are valid coords, 'false' if out of bounds
     */
    public Boolean isValidCoords(int[] coords){
        //vertical and horizontal (row and column)
        return coords[0] >= 0 && coords[0] < BOARD_SIZE && coords[1] >= 0 && coords[1] < BOARD_SIZE;
    }

    /**
     * Method to ask the player to make a move.
     * @param team 'white' if true, 'black' if false.
     */
    public void movePieceOnTurn(Team team) {
        int[] from = {}; //starting coords
        int[] to = {}; //destination coords

        System.out.println("\nIt's " + team.toString() + "' turn. Make a move!");

        System.out.println("These are the pieces of your team: ");
        List<String> piecesOwned = getListOfPiecesOfTeam(team);
        if (piecesOwned.isEmpty()) {
            System.out.println("None!");
        } else {
            piecesOwned.forEach(System.out::println);
        }

        List<int[]> legalMoves = new ArrayList<>();
        System.out.println("Enter the coordinates of the piece you wish to move: ");
        boolean searchingFrom = true;
        while (searchingFrom) { //loops until a valid pair of coords with a valid piece in them is found
            System.out.println("From [vertical, horizontal]: ");
            from = parseCoords(scanner.nextLine());

            if (from != null && getBoardSquare(from).getChessPiece() != null && getBoardSquare(from).getChessPiece().getTeam() == team) {
                //ask the Move engine for legal moves from the starting coords
                legalMoves = getValidMovesForPiece(from);
                if (legalMoves.isEmpty()) {
                    System.out.println("That piece has no legal moves. Pick another piece.");
                    continue;
                } else {
                    searchingFrom = false; //a suitable starting position was found, end loop
                }
                System.out.println("Piece selected: " + getBoardSquare(from).getIcon().getIcon() + " at '" + Arrays.toString(from) + "'\nIt can be moved to: ");
                if (legalMoves.isEmpty()) {
                    System.out.println("Nowhere!");
                } else {
                    legalMoves.forEach(move -> System.out.println(Arrays.toString(move)));
                }
            } else {
                System.out.println("Invalid Move! You can only move pieces of your team!");
            }
        }

        System.out.println("Enter the coordinates of where you want to move it: ");

        boolean searchingTo = true;
        while (searchingTo) { //loops until a valid pair of coords is found
            System.out.println("To [vertical, horizontal]: ");
            to = parseCoords(scanner.nextLine());
            final int[] check = to;
            //if boardSquare is one of the coords in legalMoves, move the piece there
            if (to != null && legalMoves.stream().anyMatch(move -> java.util.Arrays.equals(move, check))) {
                searchingTo = false; //a suitable destination was found, end loop
                move(from, to);
            } else {
                System.out.println("Can't move there! Insert valid coordinates!");
            }
        }
        refreshBoardSquareDisplayedIcon();
    }

    public static int[] parseCoords(String input) {
        input = input.trim().toLowerCase();
        try {
            // Format: "2 3" or "2,3"
            if (input.matches("\\d+\\s*,?\\s*\\d+")) {
                String[] parts = input.split("[,\\s]+");
                int row = Integer.parseInt(parts[0]);
                int col = Integer.parseInt(parts[1]);
                return new int[]{row, col};
            }

            // Format: "b2" (chess notation)
            if (input.matches("[a-h][1-8]")) {
                int col = input.charAt(0) - 'a';
                int row = 8 - Character.getNumericValue(input.charAt(1)); // 8 - row for 0-indexed arrays
                return new int[]{row, col};
            }
        } catch (Exception e) {
            System.err.println("Invalid coordinate format. Please use 'row col', 'row,col', or chess notation like 'b2'.");
        }
        return null;
    }

    /**
     * Method to move a ChessPiece from one place to the other
     * @param from starting coords of the piece you want to move
     * @param to coords of where you want the piece to go
     */
    public void move(int[] from, int[] to) {
        getBoardSquare(to).setChessPiece(getBoardSquare(from).getChessPiece());
        getBoardSquare(from).setChessPiece(null);
        String message = String.format("Moved '%s' from '%s' to '%s'.",
                getBoardSquare(to).getChessPiece().getIcon().getIcon(),
                Arrays.toString(from),
                Arrays.toString(to)
        );
        System.out.println(message);
    }

    /**
     * Retrieves a list of all valid moves for a chess piece located at the specified coordinates.
     *
     * @param coords An array representing the coordinates of the chess piece on the board.
     *               The array should have two elements: [row, column].
     * @return A list of valid moves for the chess piece, where each move is represented as an array [row, column].
     *         If the coordinates are invalid or there are no valid moves, an empty list is returned.
     */
    public List<int[]> getValidMovesForPiece(int[] coords){
        return moveHelper.getValidMovesForPiece(coords);
    }
}
