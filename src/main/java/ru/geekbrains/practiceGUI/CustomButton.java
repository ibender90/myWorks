package ru.geekbrains.practiceGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomButton extends JButton {
    char dot = Game.DOT_EMPTY;

    public CustomButton(int y, int x) {
        setText(" ");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setText(String.valueOf(Game.DOT_X));
                dot = Game.DOT_X;
                setEnabled(false);
                Game.getResponse(CustomButton.this);
            }
        });
    }
}
