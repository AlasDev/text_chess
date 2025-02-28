package com.alas.board;

import com.alas.util.BasicChessPiece;

public class BoardSquare {
    private BasicChessPiece chessPiece;
    private String icon = " ";
    String tileWhite = "⬜";
    String tileBlack = "⬛";

    public BoardSquare () {
        this.chessPiece = null;
    }

    public BoardSquare (BasicChessPiece basicChessPiece) {
        this.chessPiece = basicChessPiece;
        if (basicChessPiece != null) {
            this.icon = basicChessPiece.getIcon();
        }
    }

    public BasicChessPiece getChessPiece() {
        return chessPiece;
    }

    public void setChessPiece(BasicChessPiece chessPiece) {
        this.chessPiece = chessPiece;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(boolean color) {
        if (color) {
            this.icon = tileWhite;
        } else {
            this.icon = tileBlack;
        }
    }

    public void refreshIcon() {
        if (getChessPiece() != null) {
            this.icon = getChessPiece().getIcon();
        } else {
            this.icon = " ";
        }
    }
}
