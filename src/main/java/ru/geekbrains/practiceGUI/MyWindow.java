package ru.geekbrains.practiceGUI;

import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {
    private final int WIDTH = 640;
    private final int HEIGHT = 480;
    private int rows = 3;
    private int columns = 3;
    private CustomButton[][] buttons;
    private Game game;
    private String score;
    private JPanel panelWithButtons;

    public MyWindow() {
        setSize(WIDTH,HEIGHT);
        setLocationRelativeTo(null);
        //setBounds(500, 300, WIDTH, HEIGHT);
        setTitle("TicTacToe");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel score = new JPanel();
        JLabel text = new JLabel(setScore(game));
        score.add(text);
        add(score, BorderLayout.NORTH);

        MySettingsWindow settingsWindow = new MySettingsWindow(this);


        JButton btnSettings = new JButton("SETTINGS");
        JButton btnExit = new JButton("EXIT");
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(btnSettings);
        buttonPanel.add(btnExit);
        add(buttonPanel, BorderLayout.SOUTH);


        setVisible(true);
        btnSettings.addActionListener(e -> settingsWindow.setVisible(true));
        btnExit.addActionListener(e -> System.exit(0));
    }

    public CustomButton[][] getButtons() {
        return buttons;
    }

    public void startGame(int gameMode, int fieldSize, int winLength) {
        game = new Game();
        rows = fieldSize;
        columns = fieldSize;
        game.startNewGame(gameMode, fieldSize, winLength);
        System.out.printf("Mode: %d, Size: %d length: %d\n", gameMode, fieldSize, winLength);
    }

    public void createField(int rows, int columns) {
        if(panelWithButtons != null){
            panelWithButtons.removeAll(); //если меняю что-то в настройках, удалю старое поле с кнопками
        }
        panelWithButtons = new JPanel(new GridLayout(rows, columns));
        buttons = new CustomButton[rows][columns];
        for (int y = 0; y < columns; y++) {
            for (int x = 0; x < rows; x++) {
                CustomButton button = new CustomButton(game);
                buttons[y][x] = button;
                panelWithButtons.add(button);
            }
        }
        add(panelWithButtons);
        setVisible(true);
    }

    public String setScore(Game condition) {
        if (condition == null) {
            return " ";
        } else {
            return "Your score: " + condition.scoreHuman + "      AI score: " + condition.scoreAi;
        }
    }


}
