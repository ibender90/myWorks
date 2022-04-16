package ru.geekbrains.practiceGUI;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private static MyWindow window = new MyWindow();
    private static CustomButton[][] buttonField = window.getButtons();

    static final char DOT_X = 'X';
    private static final char DOT_0 = '0';
    static final char DOT_EMPTY = '.';

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    private static char[][] field;
    private static char dotHuman = DOT_X;
    private static char dotAi = DOT_0;
    private static int fieldSizeX = 3;
    private static int fieldSizeY = 3;
    private static int scoreHuman;
    private static int scoreAi;
    private static int roundCounter;
    private static int winLength = 3;


    public static void main(String[] args) {
        //startNewGame();

    }

    public static void getResponse(CustomButton button) { // хочу получить ответ на нажатие кнопки
        gameCheck(dotHuman);
        aiTurn();
        gameCheck(dotAi);
    }

    private static boolean simpleCheckWin(char dot) {
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

    private static void initField(int sizeX, int sizeY) { // оставлю инициализацию
        fieldSizeX = sizeX;
        fieldSizeY = sizeY;
        field = new char[fieldSizeY][fieldSizeX];

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    private static void printField() { //надо поменять на setText
        System.out.print("+");

        for (int i = 0; i < fieldSizeX * 2 + 1; i++) {
            System.out.print(i % 2 == 0 ? "-" : i / 2 + 1); //print 1-2-3-..
        }
        System.out.println();
        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(i + 1 + "|");

            for (int j = 0; j < fieldSizeX; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        for (int i = 0; i < fieldSizeX * 2 + 1; i++) {
            System.out.print("_");
        }
        System.out.println();
    }

//    private static void startNewGame() {
//        setFieldSize();
//        while (true) {
//            chooseDot();
//            playRound();
//
//            System.out.printf("SCORE:  HUMAN  AI\n" +
//                    "          %d     %d\n", scoreHuman, scoreAi);
//
//            System.out.print("Play again? (Y/N): ");
//
//            if (!scanner.next().toLowerCase(Locale.ROOT).equals("y")) {
//                System.out.println("Goodbye");
//                break;
//            }
//        }
//    }

    private static void setFieldSize() {
        do {
            System.out.println("Enter field size: ");
            fieldSizeX = scanner.nextInt();
            fieldSizeY = scanner.nextInt();
        } while (!(fieldSizeX <= 10 && fieldSizeY <= 10 && fieldSizeX > 2 && fieldSizeY > 2));
    }

    private static void playRound() {
        System.out.printf("Round %d start\n", ++roundCounter);
        initField(fieldSizeX, fieldSizeY);
        if (dotHuman == DOT_X) {
            printField();
            humanFirst();
        } else {
            aiFirst();
        }
    }

    private static void aiFirst() {
        while (true) {
            aiTurn();
            printField();
            if (gameCheck(dotAi)) {
                break;
            }
            humanTurn();
            printField();
            if (gameCheck(dotHuman)) {
                break;
            }
        }
    }

    private static void humanFirst() {
        while (true) {
            humanTurn();
            printField();
            if (gameCheck(dotHuman)) {
                break;
            }
            aiTurn();
            printField();
            if (gameCheck(dotAi)) {
                break;
            }
        }

    }

    private static boolean gameCheck(char dot) {
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

    private static void chooseDot() {
        System.out.print("To play with X type 'X', to play with '0' type anything: ");

        if (scanner.next().toLowerCase(Locale.ROOT).equals("x")) {
            dotHuman = DOT_X;
            dotAi = DOT_0;
        } else {
            dotHuman = DOT_0;
            dotAi = DOT_X;
        }
    }

    private static void humanTurn() {
        int x;
        int y;

        do {
            System.out.print("Please enter coordinates x y : ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(y, x));
        field[y][x] = dotHuman;
        buttonField[y][x].setText(String.valueOf(dotHuman));
    }

    private static void aiTurn() {
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

    private static boolean placeDotInTheMiddle() {
        //place dot in the middle or close to it
        if (isCellValid(fieldSizeY / 2, fieldSizeX / 2)) {
            buttonField[fieldSizeY / 2][fieldSizeX / 2].dot = dotAi;
            buttonField[fieldSizeY / 2][fieldSizeX / 2].setText(String.valueOf(dotAi));
            buttonField[fieldSizeY / 2][fieldSizeX / 2].setEnabled(false);
            return true;
        }
        return false;
    }

    private static boolean blockPlayer() {
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

    private static boolean winAttempt() {
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

    private static boolean isCellValid(int y, int x) {
        //return buttonField[y][x].getText().equals(" ");
        return buttonField[y][x].isEnabled();
        //return x >= 0 && y >= 0 && x < fieldSizeX && y < fieldSizeY && field[y][x] == DOT_EMPTY;
    }

    private static boolean checkDraw() {
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

    private static boolean drawLine(int y, int x, int shiftX, int shiftY, char dot) {
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
}
