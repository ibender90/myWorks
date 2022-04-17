package ru.geekbrains.practiceGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverWindow extends JFrame {
    private static final int WINDOW_WIDTH = 250;
    private static final int WINDOW_HEIGHT = 100;
    private GameEngine currentGameEngine;

    public GameOverWindow(GameEngine gameEngine){
        this.currentGameEngine = gameEngine;
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setLocationRelativeTo(null);

        setTitle(whoWin());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        String result = getResult();
        JLabel text = new JLabel(result);
        JPanel buttons = new JPanel(new GridLayout(1,2));
        add(text, BorderLayout.NORTH);

        JButton nextRound = new JButton("Play again");
        JButton exit = new JButton("Exit");
        add(buttons, BorderLayout.SOUTH);

        nextRound.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentGameEngine.resetField();
                dispose();
            }
        });
        exit.addActionListener(e->System.exit(0));

        buttons.add(nextRound);
        buttons.add(exit);
        setVisible(true);
    }

    private String getResult(){
        if(currentGameEngine.getGameMode() == 0){
            return "Computer: " + currentGameEngine.getScoreAi()+ "   " + "Player: " + currentGameEngine.getScoreHuman1();
        }
        return "Player 1 score: " + currentGameEngine.getScoreHuman1() + "      Player 2 score: " + currentGameEngine.getScoreHuman2();
    }

    private String whoWin(){
        return switch (currentGameEngine.getWhoWin()){
            case PLAYER1_WIN -> "Player1 win!";
            case PLAYER2_WIN -> "Player2 win!";
            case COMPUTER_WIN -> "Computer win";
            case DRAW -> "Draw!";
        };

    }
}
