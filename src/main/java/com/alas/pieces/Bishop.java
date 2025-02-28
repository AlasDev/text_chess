package com.alas.pieces;

import com.alas.util.BasicChessPiece;

public class Bishop implements BasicChessPiece {
    private String whiteBishop = "♝";
    private String blackBishop = "♗";

    private final Boolean team;
    private final String icon;

    /**
     * Constructor of the Bishop chess piece
     * @param team 'true' is white, 'false' is black
     */
    public Bishop (Boolean team) {
        this.team = team;
        if (team) {
            this.icon = whiteBishop;
        } else {
            this.icon = blackBishop;
        }
    }

    public Boolean getTeam() {
        return team;
    }

    public String getIcon() {
        return icon;
    }
}
