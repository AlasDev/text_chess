package com.alas.board;

import com.alas.util.BasicChessPiece;

public class BoardSquare {
    private BasicChessPiece chessPiece;
    private String icon; //piece icon shown on the board
    private String tile; //tile color
    String tileWhite = "⬜";
    String tileBlack = "⬛";

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

    public String getTile() {
        return tile;
    }

    public void setTile(boolean color) {
        if (color) {
            this.tile = tileWhite;
        } else {
            this.tile = tileBlack;
        }
    }

    /**
     * If the chess piece is not null, it sets the icon to the chess piece icon, otherwise it sets the tile color
     */
    public void refreshIcon() {
        if (getChessPiece() != null) {
            this.icon = getChessPiece().getIcon();
        } else {
            this.icon = this.tile;
        }
    }
}
