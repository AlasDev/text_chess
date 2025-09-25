package com.alas.util;

public class ChessPiece {
    private Team team;
    private PieceIcons icon;

    public PieceIcons getIcon() {
        return icon;
    }
    public void setIcon(PieceIcons icon) {
        this.icon = icon;
    }
    public Team getTeam() {
        return team;
    }
    public void setTeam(Team team) {
        this.team = team;
    }
}
