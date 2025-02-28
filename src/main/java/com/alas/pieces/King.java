package com.alas.pieces;

import com.alas.util.BasicChessPiece;

public class King implements BasicChessPiece {
    private String whiteKing = "♚";
    private String blackKing = "♔";

    private final Boolean team;
    private final String icon;

    /**
     * Constructor of the King chess piece
     * @param team 'true' is white, 'false' is black
     */
    public King (Boolean team) {
        this.team = team;
        if (team) {
            this.icon = whiteKing;
        } else {
            this.icon = blackKing;
        }
    }

    public Boolean getTeam() {
        return team;
    }

    public String getIcon() {
        return icon;
    }
}