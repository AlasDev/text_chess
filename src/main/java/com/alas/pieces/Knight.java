package com.alas.pieces;

import com.alas.util.ChessPiece;
import com.alas.util.PieceIcons;
import com.alas.util.Team;

public class Knight extends ChessPiece {

    /**
     * Constructor of the Knight chess piece
     * @param team 'WHITE' is white, 'BLACK' is black
     */
    public Knight (Team team) {
        setTeam(team);
        if (team == Team.WHITE) {
            setIcon(PieceIcons.KNIGHT_W);
        } else {
            setIcon(PieceIcons.KNIGHT_B);
        }
    }
}
