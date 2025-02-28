package com.alas.pieces;

import com.alas.util.BasicChessPiece;

public class Knight implements BasicChessPiece {
    private String whiteKnight = "♞";
    private String blackKnight = "♘";

    private final Boolean team;
    private final String icon;

    /**
     * Constructor of the Knight chess piece
     * @param team 'true' is white, 'false' is black
     */
    public Knight (Boolean team) {
        this.team = team;
        if (team) {
            this.icon = whiteKnight;
        } else {
            this.icon = blackKnight;
        }
    }

    public Boolean getTeam() {
        return team;
    }

    public String getIcon() {
        return icon;
    }
}
