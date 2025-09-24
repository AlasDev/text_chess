package com.alas.pieces;

import com.alas.util.BasicChessPiece;
import com.alas.util.PieceIcons;

public class Knight implements BasicChessPiece {

    private final boolean team;
    private final String icon;

    /**
     * Constructor of the Knight chess piece
     * @param team 'true' is white, 'false' is black
     */
    public Knight (boolean team) {
        this.team = team;
        if (team) {
            this.icon = PieceIcons.KNIGHT_W.getIcon();
        } else {
            this.icon = PieceIcons.KNIGHT_B.getIcon();
        }
    }

    public Boolean getTeam() {
        return team;
    }

    public String getIcon() {
        return icon;
    }
}
