package com.example.millgame.players;

import com.example.millgame.Board;
import com.example.millgame.pieces.PieceColor;
import com.example.millgame.Player;

public interface PlayerFactory {
    public Player create(PieceColor color, Board board);
    public Player createByLevel(PieceColor color, Board board, PlayerLevel level);
}
