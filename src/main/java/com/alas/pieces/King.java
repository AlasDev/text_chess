package com.alas.pieces;

import com.alas.util.ChessPiece;
import com.alas.util.PieceIcons;
import com.alas.util.Team;

public class King extends ChessPiece {

    /**
     * Constructor of the King chess piece
     * @param team 'WHITE' is white, 'BLACK' is black
     */
    public King (Team team) {
        setTeam(team);
        if (team == Team.WHITE) {
            setIcon(PieceIcons.KING_W);
        } else {
            setIcon(PieceIcons.KING_B);
        }
    }
}