package com.alas.pieces;

import com.alas.util.BasicChessPiece;
import com.alas.util.PieceIcons;

public class King implements BasicChessPiece {

    private final boolean team;
    private final String icon;

    /**
     * Constructor of the King chess piece
     * @param team 'true' is white, 'false' is black
     */
    public King (boolean team) {
        this.team = team;
        if (team) {
            this.icon = PieceIcons.KING_W.getIcon();
        } else {
            this.icon = PieceIcons.KING_B.getIcon();
        }
    }

    public Boolean getTeam() {
        return team;
    }

    public String getIcon() {
        return icon;
    }
}