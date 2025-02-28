package com.alas.moves;

import com.alas.board.Board;
import com.alas.util.BasicChessPiece;

import java.util.ArrayList;
import java.util.List;

public class Move extends Board {
    public Boolean isPieceValid(BasicChessPiece piece){
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

    public List<int[]> validMoves(int[] coords){
        BasicChessPiece piece = getBoardSquare(coords).getChessPiece();
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

                    while (isValidCoords(northWest) && getBoardSquare(northWest).getChessPiece() == null){
                        moves.add(northWest);
                        northWest = new int[]{coords[0]-1, coords[1]-1};
                    }

                    while (isValidCoords(northEast) && getBoardSquare(northEast).getChessPiece() == null){
                        moves.add(northEast);
                        northEast = new int[]{coords[0]+1, coords[1]-1};
                    }

                    while (isValidCoords(southEast) && getBoardSquare(southEast).getChessPiece() == null){
                        moves.add(southEast);
                        southEast = new int[]{coords[0]+1, coords[1]+1};
                    }

                    while (isValidCoords(southWest) && getBoardSquare(southWest).getChessPiece() == null){
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

                    while (isValidCoords(northWest) && getBoardSquare(northWest).getChessPiece() == null){
                        moves.add(northWest);
                        northWest = new int[]{coords[0]-1, coords[1]-1};
                    }

                    while (isValidCoords(north) && getBoardSquare(north).getChessPiece() == null){
                        moves.add(north);
                        north = new int[]{coords[0]+1, coords[1]};
                    }

                    while (isValidCoords(northEast) && getBoardSquare(northEast).getChessPiece() == null){
                        moves.add(northEast);
                        northEast = new int[]{coords[0]+1, coords[1]-1};
                    }

                    while (isValidCoords(east) && getBoardSquare(east).getChessPiece() == null){
                        moves.add(east);
                        east = new int[]{coords[0], coords[1]+1};
                    }

                    while (isValidCoords(southEast) && getBoardSquare(southEast).getChessPiece() == null){
                        moves.add(southEast);
                        southEast = new int[]{coords[0]+1, coords[1]+1};
                    }

                    while (isValidCoords(south) && getBoardSquare(south).getChessPiece() == null){
                        moves.add(south);
                        south = new int[]{coords[0]-1, coords[1]};
                    }

                    while (isValidCoords(southWest) && getBoardSquare(southWest).getChessPiece() == null){
                        moves.add(southWest);
                        southWest = new int[]{coords[0]-1, coords[1]+1};
                    }

                    while (isValidCoords(west) && getBoardSquare(west).getChessPiece() == null){
                        moves.add(west);
                        west = new int[]{coords[0], coords[1]-1};
                    }
                    break;
            }
        }
        return moves;
    }
}
