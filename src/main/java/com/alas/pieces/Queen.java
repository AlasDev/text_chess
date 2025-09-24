package com.alas.pieces;

import com.alas.util.BasicChessPiece;
import com.alas.util.PieceIcons;

public class Queen implements BasicChessPiece {

    private final boolean team;
    private final String icon;

    /**
     * Constructor of the King chess piece
     * @param team 'true' is white, 'false' is black
     */
    public Queen (boolean team) {
        this.team = team;
        if (team) {
            this.icon = PieceIcons.QUEEN_W.getIcon();
        } else {
            this.icon = PieceIcons.QUEEN_B.getIcon();
        }
    }

    public Boolean getTeam() {
        return team;
    }

    public String getIcon() {
        return icon;
    }
}