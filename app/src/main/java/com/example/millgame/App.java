package com.example.millgame;

public class App implements Runnable {

    private Thread threadGUI;

    public static void main(String[] args){
        System.out.println("HELLO WORLD!");
        // COMMAND LINE PARSER - TO ENABLE LOG TO CONSOLE
        new App().start();
    }

    @Override
    public void run() {
        GameGUI gameGUI = new GameGUI();
        gameGUI.setVisible(true);
    }

    private void start() {
        threadGUI = new Thread(this);
        threadGUI.start();
    }

    public void stop() {
        try {
            threadGUI.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}