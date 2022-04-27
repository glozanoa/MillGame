package com.example.millgame;

import java.util.ArrayList;
import java.util.List;

interface MillGameBuilderInterface {
    public void reset();
    public void setGameMode(GameMode mode);
    public void setRobotPlayerDifficulty(RobotPlayerLevel level);
    public void addPlayer(PieceColor color, PlayerType type);
    public void buildBoard(GameVariant variant);
}

public class MillGameBuilder implements MillGameBuilderInterface {
    private MillGame game;
    private Board board;
    private GameMode mode;
    private RobotPlayerLevel robotDifficulty = RobotPlayerLevel.EASY;
    private ArrayList<Player> players;

    public void reset(){
        game = new MillGame();
        players = new ArrayList<Player>();
    }

    public void setGameMode(GameMode mode){
        this.mode = mode;
    }

    public void setRobotPlayerDifficulty(RobotPlayerLevel level){
        this.robotDifficulty = level;
    }

    public void buildBoard(GameVariant variant){
        board = BoardCreatorDirector.makeMMBoard(variant);
        game.setBoard(board);
    }

    /*
    public void createPlayers(GameMode mode)
    {
        players.add(new HumanPlayer(PieceColor.WHITE, board));
        if (mode == GameMode.HUMAN_HUMAN){

        }
        else {

        }

    }
     */

    public void addPlayer(PieceColor color, PlayerType type)
    {
        Player player;

        if(type == PlayerType.HUMAN)
            player = new HumanPlayer(color, board);
        else
            player = new RobotPlayer(color, board, robotDifficulty);

        players.add(player);
    }

    public MillGame getResult(){
        TurnIterator itr = new TurnIterator(players);
        game.setTurnIterator(itr);
        game.setPlayers(players);
        return game;
    }
}
