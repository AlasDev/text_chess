package com.alas.pieces;

import com.alas.util.ChessPiece;
import com.alas.util.PieceIcons;
import com.alas.util.Team;

public class Queen extends ChessPiece {

    /**
     * Constructor of the King chess piece
     * @param team 'WHITE' is white, 'BLACK' is black
     */
    public Queen (Team team) {
        setTeam(team);
        if (team == Team.WHITE) {
            setIcon(PieceIcons.QUEEN_W);
        } else {
            setIcon(PieceIcons.QUEEN_B);
        }
    }
}