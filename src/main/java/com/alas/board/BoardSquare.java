package com.alas.board;

import com.alas.util.ChessPiece;
import com.alas.util.PieceIcons;

public class BoardSquare {
    private ChessPiece chessPiece;
    private String tile; //tile color
    private String displayedIcon;

    public BoardSquare (ChessPiece chessPiece) {
        this.chessPiece = chessPiece;
    }

    public ChessPiece getChessPiece() {
        return chessPiece;
    }

    public void setChessPiece(ChessPiece chessPiece) {
        this.chessPiece = chessPiece;
    }

    public PieceIcons getIcon() {
        return this.chessPiece.getIcon();
    }

    public String getTile() {
        return tile;
    }

    public void setTileColor(boolean color) {
        if (color) {
            this.tile = "⬜";
        } else {
            this.tile = "⬛";
        }
    }

    /**
     * Updates the displayed icon for this board square.
     * If no chess piece is present on the square, the displayed icon is set to the tile color.
     * Otherwise, the displayed icon is set to the string representation of the chess piece's icon.
     */
    public void refreshDisplayedIcon() {
        if (this.chessPiece == null) {
            setDisplayedIcon(this.tile);
            return;
        }
        setDisplayedIcon(this.chessPiece.getIcon().getIcon());
    }

    public void setDisplayedIcon(String displayedIcon) {
        this.displayedIcon = displayedIcon;
    }

    /**
     * Retrieves the displayed icon for this board square.
     * The displayed icon represents either the icon of the chess piece present
     * on the square or the tile color if no chess piece is present.
     *
     * @return the displayed icon as a string
     */
    public String getDisplayedIcon() {
        return this.displayedIcon;
    }
}
