package com.alas.util;

public enum PieceIcons {
    PAWN_W("♟"), ROOK_W("♜"), KNIGHT_W("♞"), BISHOP_W("♝"), QUEEN_W("♛"), KING_W("♚"),
    PAWN_B("♙"), ROOK_B("♖"), KNIGHT_B("♘"), BISHOP_B("♗"), QUEEN_B("♕"), KING_B("♔");

    private final String icon;

    PieceIcons(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }
}
