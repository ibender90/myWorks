package ru.geekbrains.practiceGUI;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private static MyWindow window;
    private static CustomButton[][] buttonField;
    public static final int MODE_VS_AI = 0;
    public static final int MODE_VS_HUMAN = 1;
    private int gameMode;
    private boolean isGameOver;
    private boolean isInitialized;

    static final char DOT_X = 'X';
    private final char DOT_0 = '0';
    static final char DOT_EMPTY = '.';

    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();


    private char dotHuman = DOT_X;
    private char dotAi = DOT_0;
    private int fieldSizeX;
    private int fieldSizeY;
    int scoreHuman;
    int scoreAi;
    private int roundCounter;
    private int winLength;

    public static void main(String[] args) {
        window = new MyWindow();
    }
    public Game() {
    }
    public void startNewGame(int gameMode, int fieldSize, int winLength) {
        this.gameMode = gameMode;
        fieldSizeX = fieldSize;
        fieldSizeY = fieldSize;
        this.winLength = winLength;
        window.createField(fieldSizeY,fieldSizeX);
        isGameOver = false;
        isInitialized = true;
        buttonField = window.getButtons();
    }


    public void getResponse() { // хочу получить ответ на нажатие кнопки
        //сделаю режим для игры против компа
        if(gameCheck(dotHuman)){
            //resetField();
            showGameOverWindow();
        } else {
            aiTurn();
            if(gameCheck(dotAi)){
                //resetField();
                showGameOverWindow();
            }
        }
    }

    private boolean simpleCheckWin(char dot) {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (buttonField[y][x].dot == dot) { //if cycle found dot
                    if (drawLine(y, x, 1, 0, dot) ||
                            drawLine(y, x, 0, 1, dot) ||
                            drawLine(y, x, 1, 1, dot) ||
                            drawLine(y, x, 1, -1, dot)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    private void playRound() {
        System.out.printf("Round %d start\n", ++roundCounter);
        if (dotHuman == DOT_X) {

            humanFirst();
        } else {
            aiFirst();
        }
    }

    private void aiFirst() {
        while (true) {
            aiTurn();
            if (gameCheck(dotAi)) {
                break;
            }
            humanTurn();
            if (gameCheck(dotHuman)) {
                break;
            }
        }
    }

    private void humanFirst() {
        while (true) {
            humanTurn();

            if (gameCheck(dotHuman)) {
                break;
            }
            aiTurn();
            if (gameCheck(dotAi)) {
                break;
            }
        }

    }

    private boolean gameCheck(char dot) {
        if (simpleCheckWin(dot) && dot == dotHuman) {
            System.out.println("You win!");
            scoreHuman++;
            return true;
        } else if (simpleCheckWin(dot) && dot == dotAi) {
            System.out.println("Computer win!");
            scoreAi++;
            return true;
        }
        return checkDraw();
    }

    private void chooseDot() {
        System.out.print("To play with X type 'X', to play with '0' type anything: ");

        if (scanner.next().toLowerCase(Locale.ROOT).equals("x")) {
            dotHuman = DOT_X;
            dotAi = DOT_0;
        } else {
            dotHuman = DOT_0;
            dotAi = DOT_X;
        }
    }

    private void humanTurn() {
        int x;
        int y;

        do {
            System.out.print("Please enter coordinates x y : ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(y, x));

        buttonField[y][x].setText(String.valueOf(dotHuman));
    }

    private void aiTurn() {
        if (placeDotInTheMiddle()) {
            System.out.println("ai placed dot in the middle or next to it");
        } else if (winAttempt()) {
            System.out.println("ai tried to win");
        } else if (blockPlayer()) {
            System.out.println("ai blocked player");
        } else {
            int x;
            int y;

            do {
                x = random.nextInt(fieldSizeX);
                y = random.nextInt(fieldSizeY);
            } while (!isCellValid(y, x));
            buttonField[y][x].dot = dotAi;
            buttonField[y][x].setText(String.valueOf(DOT_0));
            buttonField[y][x].setEnabled(false);
            System.out.println("ai made random move");
        }
    }

    private boolean placeDotInTheMiddle() {
        //place dot in the middle or close to it
        if (isCellValid(fieldSizeY / 2, fieldSizeX / 2)) {
            buttonField[fieldSizeY / 2][fieldSizeX / 2].dot = dotAi;
            buttonField[fieldSizeY / 2][fieldSizeX / 2].setText(String.valueOf(dotAi));
            buttonField[fieldSizeY / 2][fieldSizeX / 2].setEnabled(false);
            return true;
        }
        return false;
    }

    private boolean blockPlayer() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellValid(y, x)) {
                    buttonField[y][x].dot = dotHuman;
                    if (simpleCheckWin(dotHuman)) {
                        buttonField[y][x].dot = dotAi;
                        buttonField[y][x].setText(String.valueOf(dotAi));
                        buttonField[y][x].setEnabled(false);
                        return true;
                    } else {
                        buttonField[y][x].dot = DOT_EMPTY;
                    }
                }
            }
        }
        return false;
    }

    private boolean winAttempt() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellValid(y, x)) {
                    buttonField[y][x].dot = dotAi;
                    if (simpleCheckWin(dotAi)) {
                        buttonField[y][x].setText(String.valueOf(dotAi));
                        buttonField[y][x].setEnabled(false);
                        return true;
                    } else {
                        buttonField[y][x].dot = DOT_EMPTY;
                    }
                }
            }
        }
        return false;
    }

    private boolean isCellValid(int y, int x) {
        //return buttonField[y][x].getText().equals(" ");
        return buttonField[y][x].isEnabled();
        //return x >= 0 && y >= 0 && x < fieldSizeX && y < fieldSizeY && field[y][x] == DOT_EMPTY;
    }

    private boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (buttonField[y][x].isEnabled()) {
                    return false; //while we can find any empty cell
                }
            }
        }
        System.out.println("DRAW");
        return true;
    }

    private boolean drawLine(int y, int x, int shiftX, int shiftY, char dot) {
        int winCounter = 0;

        while (x < fieldSizeX && y < fieldSizeY && y >= 0 && buttonField[y][x].dot == dot) { //y-- will happen
            winCounter++;
            if (winCounter == winLength) {
                return true;
            }
            y = y + shiftY;
            x = x + shiftX;
        }
        return false;
    }

    public void resetField(){
        for(CustomButton[] row : buttonField){
            for (CustomButton button:
                 row) {
                button.setEnabled(true);
                button.dot = DOT_EMPTY;
                button.setText(" ");
            }
        }
    }

    private void showGameOverWindow(){
        new GameOverWindow(this);
    }
}
