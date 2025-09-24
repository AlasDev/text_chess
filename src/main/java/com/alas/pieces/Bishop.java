package com.alas.pieces;

import com.alas.util.BasicChessPiece;
import com.alas.util.PieceIcons;

public class Bishop implements BasicChessPiece {

    private final boolean team;
    private final String icon;

    /**
     * Constructor of the Bishop chess piece
     * @param team 'true' is white, 'false' is black
     */
    public Bishop (boolean team) {
        this.team = team;
        if (team) {
            this.icon = PieceIcons.BISHOP_W.getIcon();
        } else {
            this.icon = PieceIcons.BISHOP_B.getIcon();
        }
    }

    public Boolean getTeam() {
        return team;
    }

    public String getIcon() {
        return icon;
    }
}
