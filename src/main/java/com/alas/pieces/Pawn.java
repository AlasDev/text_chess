package com.alas.pieces;

import com.alas.util.BasicChessPiece;
import com.alas.util.PieceIcons;

public class Pawn implements BasicChessPiece {

    private final boolean team;
    private final String icon;

    /**
     * Constructor of the Bishop chess piece
     * @param team 'true' is white, 'false' is black
     */
    public Pawn (boolean team) {
        this.team = team;
        if (team) {
            this.icon = PieceIcons.PAWN_W.getIcon();
        } else {
            this.icon = PieceIcons.PAWN_B.getIcon();
        }
    }

    public Boolean getTeam() {
        return team;
    }

    public String getIcon() {
        return icon;
    }
}
