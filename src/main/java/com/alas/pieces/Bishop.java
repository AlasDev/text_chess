package com.alas.pieces;

import com.alas.util.ChessPiece;
import com.alas.util.PieceIcons;
import com.alas.util.Team;

public class Bishop extends ChessPiece {

    /**
     * Constructor of the Bishop chess piece
     * @param team 'WHITE' is white, 'BLACK' is black
     */
    public Bishop (Team team) {
        setTeam(team);
        if (team == Team.WHITE) {
            setIcon(PieceIcons.BISHOP_W);
        } else {
            setIcon(PieceIcons.BISHOP_B);
        }
    }
}
