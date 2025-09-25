package com.alas.moves;

import com.alas.board.Board;
import com.alas.util.ChessPiece;
import com.alas.util.Team;

import java.util.ArrayList;
import java.util.List;

public class Move {
    private final Board board;

    public Move(Board board) {
        this.board = board;
    }

    public Boolean isPieceValid(ChessPiece piece){
        List<String> pieces = List.of(
                "Bishop",
                "King",
                "Knight",
                "Pawn",
                "Queen",
                "Rook"
        );
        String pieceType = piece.getClass().getSimpleName();
        return pieces.contains(pieceType);
    }

    public List<int[]> getValidMovesForPiece(int[] coords){
        ChessPiece piece = board.getBoardSquare(coords).getChessPiece();
        List<int[]> moves = new ArrayList<>();
        if (isPieceValid(piece)){

            int[] northWest; // Move up-left
            int[] north;     // Move up
            int[] northEast; // Move up-right
            int[] east;      // Move right
            int[] southEast; // Move down-right
            int[] south;     //Move down
            int[] southWest; //Move down-left
            int[] west;      // Move left

            String pieceType = piece.getClass().getSimpleName();
            switch (pieceType){
                case "Bishop":
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

                case "King":
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

                case "Knight":
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

                case "Pawn":
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

                case "Queen":
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

                case "Rook":
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
        }
        return moves;
    }
}
