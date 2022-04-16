package ru.geekbrains.practiceGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverWindow extends JFrame {
    private static final int WINDOW_WIDTH = 200;
    private static final int WINDOW_HEIGHT = 100;
    Game currentGame;

    public GameOverWindow(Game game){
        this.currentGame = game;
        setBounds(500, 300, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Round is finished");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel text = new JLabel("result");
        JPanel buttons = new JPanel(new GridLayout(1,2));
        add(text, BorderLayout.NORTH);

        JButton nextRound = new JButton("Play again");
        JButton exit = new JButton("Exit");
        add(buttons, BorderLayout.SOUTH);

        nextRound.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentGame.resetField();
                dispose();
            }
        });
        exit.addActionListener(e->System.exit(0));

        buttons.add(nextRound);
        buttons.add(exit);
        setVisible(true);
    }
}
