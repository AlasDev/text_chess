package com.alas.pieces;

import com.alas.util.BasicChessPiece;
import com.alas.util.PieceIcons;

public class Rook implements BasicChessPiece {

    private final boolean team;
    private final String icon;

    /**
     * Constructor of the Rook chess piece
     * @param team 'true' is white, 'false' is black
     */
    public Rook (boolean team) {
        this.team = team;
        if (team) {
            this.icon = PieceIcons.ROOK_W.getIcon();
        } else {
            this.icon = PieceIcons.ROOK_B.getIcon();
        }
    }

    public Boolean getTeam() {
        return team;
    }

    public String getIcon() {
        return icon;
    }
}
