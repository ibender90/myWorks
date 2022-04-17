package ru.geekbrains.practiceGUI;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private final int WIDTH = 640;
    private final int HEIGHT = 480;
    private int rows = 3;
    private int columns = 3;
    private CustomButton[][] buttons;
    private GameEngine gameEngine;
    private String score;
    private JPanel panelWithButtons;

    public GameWindow() {
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setTitle("TicTacToe");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        if(viewRoundCounter()){
            repaint();
        };

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
        gameEngine = new GameEngine();
        rows = fieldSize;
        columns = fieldSize;
        gameEngine.startNewGame(gameMode, fieldSize, winLength);
        System.out.printf("Mode: %d, Size: %d length: %d\n", gameMode, fieldSize, winLength);
    }

    public void createField(int rows, int columns) {
        if (panelWithButtons != null) {
            panelWithButtons.removeAll(); //если меняю что-то в настройках, удалю старое поле с кнопками
        }
        panelWithButtons = new JPanel(new GridLayout(rows, columns));
        buttons = new CustomButton[rows][columns];
        for (int y = 0; y < columns; y++) {
            for (int x = 0; x < rows; x++) {
                CustomButton button = new CustomButton(gameEngine);
                buttons[y][x] = button;
                panelWithButtons.add(button);
            }
        }
        add(panelWithButtons);
        setVisible(true);
    }

    public boolean viewRoundCounter(){
        JPanel round = new JPanel();
        int roundNumber = gameEngine == null ? 1 : gameEngine.getRoundCounter();
        JLabel text = new JLabel("Round: " + roundNumber);
        round.add(text);
        add(round, BorderLayout.NORTH);
        return true;
    }
}
