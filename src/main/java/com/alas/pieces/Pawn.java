package com.alas.pieces;

import com.alas.util.BasicChessPiece;

public class Pawn implements BasicChessPiece {

    private final Boolean team;
    private final String icon;

    /**
     * Constructor of the Bishop chess piece
     * @param team 'true' is white, 'false' is black
     */
    public Pawn (Boolean team) {
        this.team = team;
        if (team) {
            this.icon = "♟";
        } else {
            this.icon = "♙";
        }
    }

    public Boolean getTeam() {
        return team;
    }

    public String getIcon() {
        return icon;
    }
}
