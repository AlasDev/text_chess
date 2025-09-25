package com.alas.pieces;

import com.alas.util.ChessPiece;
import com.alas.util.PieceIcons;
import com.alas.util.Team;

public class Pawn extends ChessPiece {

    /**
     * Constructor of the Bishop chess piece
     * @param team 'WHITE' is white, 'BLACK' is black
     */
    public Pawn (Team team) {
        setTeam(team);
        if (team == Team.WHITE) {
            setIcon(PieceIcons.PAWN_W);
        } else {
            setIcon(PieceIcons.PAWN_B);
        }
    }
}
