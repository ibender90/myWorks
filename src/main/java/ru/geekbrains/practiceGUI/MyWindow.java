package ru.geekbrains.practiceGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {
    private final int WIDTH = 640;
    private final int HEIGHT = 480;
    private int rows = 3;
    private int columns = 3;
    private CustomButton[][] buttons = new CustomButton[3][3];

    public MyWindow() { //пишу конструктор с описанием содержимого окна
        setBounds(500, 300, WIDTH, HEIGHT);
        setTitle("My first window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new GridLayout(3, 3)); //таблица которая заполнит всё пространство окна
        for (int y = 0; y < columns; y++) {
            for (int x = 0; x < rows; x++) {
                CustomButton button = new CustomButton(y, x);
                buttons[y][x] = button;
                add(button);
            }
        }

        setVisible(true);
    }

    public CustomButton[][] getButtons() {
        return buttons;
    }
}
