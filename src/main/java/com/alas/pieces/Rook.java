package com.alas.pieces;

import com.alas.util.BasicChessPiece;

public class Rook implements BasicChessPiece {

    private final Boolean team;
    private final String icon;

    /**
     * Constructor of the Rook chess piece
     * @param team 'true' is white, 'false' is black
     */
    public Rook (Boolean team) {
        this.team = team;
        if (team) {
            this.icon = "♜";
        } else {
            this.icon = "♖";
        }
    }

    public Boolean getTeam() {
        return team;
    }

    public String getIcon() {
        return icon;
    }
}
