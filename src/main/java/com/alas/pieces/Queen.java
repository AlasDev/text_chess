package com.alas.pieces;

import com.alas.util.BasicChessPiece;

public class Queen implements BasicChessPiece {

    private final Boolean team;
    private final String icon;

    /**
     * Constructor of the King chess piece
     * @param team 'true' is white, 'false' is black
     */
    public Queen (Boolean team) {
        this.team = team;
        if (team) {
            this.icon = "♛";
        } else {
            this.icon = "♕";
        }
    }

    public Boolean getTeam() {
        return team;
    }

    public String getIcon() {
        return icon;
    }
}