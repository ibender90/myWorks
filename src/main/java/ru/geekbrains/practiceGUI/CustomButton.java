package ru.geekbrains.practiceGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomButton extends JButton {
    char dot = GameEngine.DOT_EMPTY;
    GameEngine gameEngine;

    public CustomButton(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
        setText(" ");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(gameEngine.getGameMode() == GameEngine.MODE_VS_AI) {
                    placeX();
                    gameEngine.getResponseFromAI();
                } else {
                    if(gameEngine.isPlayer1Turn()) {
                        placeX();
                    } else {
                        place0();
                    }
                }
            }
        });
    }

    private void place0() {
        setText(String.valueOf(GameEngine.DOT_0));
        dot = GameEngine.DOT_0;
        setEnabled(false);
        gameEngine.checkResult(GameEngine.DOT_0);
    }

    private void placeX(){
        setText(String.valueOf(GameEngine.DOT_X));
        dot = GameEngine.DOT_X;
        setEnabled(false);
        gameEngine.checkResult(GameEngine.DOT_X);
    }
}
