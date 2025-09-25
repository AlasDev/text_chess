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

    public String getTileColor() {
        return tile;
    }

    /**
     * Sets the tile color for this board square.
     * Updates the tile to a white square ("⬜") if the provided color is true,
     * or to a black square ("⬛") if the color is false.
     *
     * @param color a boolean indicating the tile color; true for white, false for black
     */
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

    public void setDisplayedIcon(String newIcon) {
        this.displayedIcon = newIcon;
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
