package com.alas.pieces;

import com.alas.util.ChessPiece;
import com.alas.util.PieceIcons;
import com.alas.util.Team;

public class Rook extends ChessPiece {

    /**
     * Constructor of the Rook chess piece
     * @param team 'WHITE' is white, 'BLACK' is black
     */
    public Rook (Team team) {
        setTeam(team);
        if (team == Team.WHITE) {
            setIcon(PieceIcons.ROOK_W);
        } else {
            setIcon(PieceIcons.ROOK_B);
        }
    }
}
