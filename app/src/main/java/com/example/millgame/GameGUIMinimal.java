package com.example.millgame;

import com.example.millgame.boards.BoardPanel;
import com.example.millgame.exceptions.RankedException;
import com.example.millgame.logging.TraceLogger;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;

public class GameGUIMinimal extends JFrame {
    /*
     * Minimal GUI version of game (only GamePanel)
     */

    public GameGUIMinimal(MillGame.GameVariant variant,
                          MillGame.GameMode mode) throws RankedException { // NOTE: handle this exception (ASAP)
        super();

        TraceLogger.log(Level.INFO, "Initializing GameGUIMinimal");
        setTitle(Constants.title);
        getContentPane().setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        MillGame game = new MillGameBuilder().build(variant, mode);
        game.nextTurn(); // init game turn

        BoardPanel boardPanel = game.getBoardPanel();
        boardPanel.setBackground(new Color(128, 64, 32));

        Container mainPanel = this.getContentPane();
        mainPanel.add(boardPanel, BorderLayout.CENTER);
    }
}