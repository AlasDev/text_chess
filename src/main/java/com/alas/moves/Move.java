package com.alas.moves;

import com.alas.board.Board;
import com.alas.util.ChessPiece;
import com.alas.util.PieceIcons;
import com.alas.util.Team;

import java.util.ArrayList;
import java.util.List;

public class Move {
    private final Board board;

    public Move(Board board) {
        this.board = board;
    }

    /**
     * Calculates all valid moves for a chess piece located at the given coordinates.
     * The valid moves depend on the type of chess piece and the current state of the board.
     *
     * @param coords an array containing the row and column indices of the chess piece's current position on the board.
     *               The format is {row, column}, using a 2D grid with zero-based indexing.
     * @return a list of valid moves for the chess piece at the specified location.
     *         Each move is represented as an int array {row, column}, indicating the target position of a valid move.
     */
    public List<int[]> getValidMovesForPiece(int[] coords){
        ChessPiece piece = board.getBoardSquare(coords).getChessPiece();
        List<int[]> moves = new ArrayList<>();

        PieceIcons pieceIcon = piece.getIcon();
        if (pieceIcon != null){

            int[] northWest; // Move up-left
            int[] north;     // Move up
            int[] northEast; // Move up-right
            int[] east;      // Move right
            int[] southEast; // Move down-right
            int[] south;     //Move down
            int[] southWest; //Move down-left
            int[] west;      // Move left

            switch (pieceIcon){
                case PieceIcons.BISHOP_W:
                case PieceIcons.BISHOP_B:
                    northWest = new int[]{coords[0]-1, coords[1]-1}; // Move up-left
                    northEast = new int[]{coords[0]+1, coords[1]-1}; // Move up-right
                    southEast = new int[]{coords[0]+1, coords[1]+1}; // Move down-right
                    southWest = new int[]{coords[0]-1, coords[1]+1}; // Move down-left

                    while (board.isValidCoords(northWest) && board.getBoardSquare(northWest).getChessPiece() == null){
                        moves.add(northWest);
                        northWest = new int[]{coords[0]-1, coords[1]-1};
                    }

                    while (board.isValidCoords(northEast) && board.getBoardSquare(northEast).getChessPiece() == null){
                        moves.add(northEast);
                        northEast = new int[]{coords[0]+1, coords[1]-1};
                    }

                    while (board.isValidCoords(southEast) && board.getBoardSquare(southEast).getChessPiece() == null){
                        moves.add(southEast);
                        southEast = new int[]{coords[0]+1, coords[1]+1};
                    }

                    while (board.isValidCoords(southWest) && board.getBoardSquare(southWest).getChessPiece() == null){
                        moves.add(southWest);
                        southWest = new int[]{coords[0]-1, coords[1]+1};
                    }
                    break;

                case PieceIcons.KING_W:
                case PieceIcons.KING_B:
                    northWest = new int[]{coords[0]-1, coords[1]-1}; // Move up-left
                    north = new int[]{coords[0]+1, coords[1]};       // Move up
                    northEast = new int[]{coords[0]+1, coords[1]-1}; // Move up-right
                    east = new int[]{coords[0], coords[1]+1};        // Move right
                    southEast = new int[]{coords[0]+1, coords[1]+1}; // Move down-right
                    south = new int[]{coords[0]-1, coords[1]};       // Move down
                    southWest = new int[]{coords[0]-1, coords[1]+1}; // Move down-left
                    west = new int[]{coords[0], coords[1]-1};        // Move left

                    if (board.isValidCoords(northWest) && board.getBoardSquare(northWest).getChessPiece() == null){
                        moves.add(northWest);
                    }

                    if (board.isValidCoords(north) && board.getBoardSquare(north).getChessPiece() == null){
                        moves.add(north);
                    }

                    if (board.isValidCoords(northEast) && board.getBoardSquare(northEast).getChessPiece() == null){
                        moves.add(northEast);
                    }

                    if (board.isValidCoords(east) && board.getBoardSquare(east).getChessPiece() == null){
                        moves.add(east);
                    }

                    if (board.isValidCoords(southEast) && board.getBoardSquare(southEast).getChessPiece() == null){
                        moves.add(southEast);
                    }

                    if (board.isValidCoords(south) && board.getBoardSquare(south).getChessPiece() == null){
                        moves.add(south);
                    }

                    if (board.isValidCoords(southWest) && board.getBoardSquare(southWest).getChessPiece() == null){
                        moves.add(southWest);
                    }

                    if (board.isValidCoords(west) && board.getBoardSquare(west).getChessPiece() == null){
                        moves.add(west);
                    }
                    break;

                case PieceIcons.KNIGHT_W:
                case PieceIcons.KNIGHT_B:
                    int[][] knightMoves = {
                            {2, 1},   // Move north 2, east 1
                            {2, -1},  // Move north 2, west 1
                            {-2, 1},  // Move south 2, east 1
                            {-2, -1}, // Move south 2, west 1
                            {1, 2},   // Move east 1, north 2
                            {1, -2},  // Move east 1, south 2
                            {-1, 2},  // Move west 1, north 2
                            {-1, -2}  // Move west 1, south 2
                    };

                    for (int[] move : knightMoves) {
                        int[] target = new int[] {
                                coords[0] + move[0],
                                coords[1] + move[1]
                        };

                        if (board.isValidCoords(target) && board.getBoardSquare(target).getChessPiece() == null) {
                            moves.add(target);
                        }
                    }
                    break;

                case PieceIcons.PAWN_W:
                case PieceIcons.PAWN_B:
                    Team team = board.getBoardSquare(coords).getChessPiece().getTeam();
                    if (team == Team.WHITE) { //white
                        int[] firstMove = new int[] {coords[0]-2, coords[1]}; // Move up by 2
                        northWest = new int[]{coords[0]-1, coords[1]-1}; // Move up-left
                        north = new int[]{coords[0]-1, coords[1]};       // Move up
                        northEast = new int[]{coords[0]-1, coords[1]+1}; // Move up-right

                        if (board.isValidCoords(firstMove) && board.getBoardSquare(firstMove).getChessPiece() == null && coords[0] == 6) {
                            moves.add(firstMove);
                        }
                        if (board.isValidCoords(northWest) && board.getBoardSquare(northWest).getChessPiece() != null) {
                            moves.add(northWest);
                        }
                        if (board.isValidCoords(north) && board.getBoardSquare(north).getChessPiece() == null) {
                            moves.add(north);
                        }
                        if (board.isValidCoords(northEast) && board.getBoardSquare(northEast).getChessPiece() != null) {
                            moves.add(northEast);
                        }
                    } else { //black
                        int[] firstMove = new int[] {coords[0]+2, coords[1]}; // Move up by 2
                        southWest = new int[]{coords[0]+1, coords[1]-1}; // Move down-left
                        south = new int[]{coords[0]+1, coords[1]};       // Move down
                        southEast = new int[]{coords[0]+1, coords[1]+1}; // Move down-right

                        if (board.isValidCoords(firstMove) && board.getBoardSquare(firstMove).getChessPiece() == null && coords[0] == 1) {
                            moves.add(firstMove);
                        }
                        if (board.isValidCoords(southWest) && board.getBoardSquare(southWest).getChessPiece() != null) {
                            moves.add(southWest);
                        }
                        if (board.isValidCoords(south) && board.getBoardSquare(south).getChessPiece() == null) {
                            moves.add(south);
                        }
                        if (board.isValidCoords(southEast) && board.getBoardSquare(southEast).getChessPiece() != null) {
                            moves.add(southEast);
                        }
                    }
                    break;

                case PieceIcons.QUEEN_W:
                case PieceIcons.QUEEN_B:
                    northWest = new int[]{coords[0]-1, coords[1]-1}; // Move up-left
                    north = new int[]{coords[0]+1, coords[1]};       // Move up
                    northEast = new int[]{coords[0]+1, coords[1]-1}; // Move up-right
                    east = new int[]{coords[0], coords[1]+1};        // Move right
                    southEast = new int[]{coords[0]+1, coords[1]+1}; // Move down-right
                    south = new int[]{coords[0]-1, coords[1]};       // Move down
                    southWest = new int[]{coords[0]-1, coords[1]+1}; // Move down-left
                    west = new int[]{coords[0], coords[1]-1};        // Move left

                    while (board.isValidCoords(northWest) && board.getBoardSquare(northWest).getChessPiece() == null){
                        moves.add(northWest);
                        northWest = new int[]{coords[0]-1, coords[1]-1};
                    }

                    while (board.isValidCoords(north) && board.getBoardSquare(north).getChessPiece() == null){
                        moves.add(north);
                        north = new int[]{coords[0]+1, coords[1]};
                    }

                    while (board.isValidCoords(northEast) && board.getBoardSquare(northEast).getChessPiece() == null){
                        moves.add(northEast);
                        northEast = new int[]{coords[0]+1, coords[1]-1};
                    }

                    while (board.isValidCoords(east) && board.getBoardSquare(east).getChessPiece() == null){
                        moves.add(east);
                        east = new int[]{coords[0], coords[1]+1};
                    }

                    while (board.isValidCoords(southEast) && board.getBoardSquare(southEast).getChessPiece() == null){
                        moves.add(southEast);
                        southEast = new int[]{coords[0]+1, coords[1]+1};
                    }

                    while (board.isValidCoords(south) && board.getBoardSquare(south).getChessPiece() == null){
                        moves.add(south);
                        south = new int[]{coords[0]-1, coords[1]};
                    }

                    while (board.isValidCoords(southWest) && board.getBoardSquare(southWest).getChessPiece() == null){
                        moves.add(southWest);
                        southWest = new int[]{coords[0]-1, coords[1]+1};
                    }

                    while (board.isValidCoords(west) && board.getBoardSquare(west).getChessPiece() == null){
                        moves.add(west);
                        west = new int[]{coords[0], coords[1]-1};
                    }
                    break;

                case PieceIcons.ROOK_W:
                case PieceIcons.ROOK_B:
                    north = new int[]{coords[0]+1, coords[1]};       // Move up
                    east = new int[]{coords[0], coords[1]+1};        // Move right
                    south = new int[]{coords[0]-1, coords[1]};       // Move down
                    west = new int[]{coords[0], coords[1]-1};        // Move left

                    while (board.isValidCoords(north) && board.getBoardSquare(north).getChessPiece() == null){
                        moves.add(north);
                        north = new int[]{coords[0]+1, coords[1]};
                    }

                    while (board.isValidCoords(east) && board.getBoardSquare(east).getChessPiece() == null){
                        moves.add(east);
                        east = new int[]{coords[0], coords[1]+1};
                    }

                    while (board.isValidCoords(south) && board.getBoardSquare(south).getChessPiece() == null){
                        moves.add(south);
                        south = new int[]{coords[0]-1, coords[1]};
                    }

                    while (board.isValidCoords(west) && board.getBoardSquare(west).getChessPiece() == null){
                        moves.add(west);
                        west = new int[]{coords[0], coords[1]-1};
                    }
                    break;
            }
        } else {
            System.err.println("Could not recognize the selected piece!");
        }
        return moves;
    }
}
