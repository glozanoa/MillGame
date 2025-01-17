package com.example.millgame;

import com.example.millgame.boards.BoardCreatorDirector;
import com.example.millgame.exceptions.RankedException;
import com.example.millgame.misc.Color;
import com.example.millgame.players.PlayerFactory;
import com.example.millgame.players.PlayerType;

import static org.junit.jupiter.api.Assertions.*;

import com.example.millgame.turns.TurnIterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


@Disabled("PlayerFactory.create(PlayerType, Color, Board) method was delete - UPDATE")
public class TurnIteratorTest {
    private MillGame game;

    @BeforeEach
    public void initTurnIterator() throws RankedException {
        MillGame.GameVariant variant = MillGame.GameVariant.NINE_MEN_MORRIS; //default game variant
        MillGame.GameMode mode = MillGame.GameMode.HUMAN_HUMAN;

        game = new MillGameBuilder(variant)
                .reset()
                .buildBoard()
                .setRandomTurn(false)
                .initTurnIterator()
                .createPlayers(mode)
                .build();
    }

    @Test
    public void nextTurnTest()
    {
        Player player = game.getActivePlayer();
        Player opponent = game.getOpponentPlayer();

        assertEquals(opponent, game.nextTurn());
        assertEquals(opponent, game.getActivePlayer());
        assertEquals(player, game.nextTurn());
    }
}
