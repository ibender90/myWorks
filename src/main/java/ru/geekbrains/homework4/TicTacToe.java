package ru.geekbrains.homework4;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static final char DOT_X = 'X';
    private static final char DOT_0 = '0';
    private static final char DOT_EMPTY = '.';

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    private static char[][] field;
    private static char dotHuman;
    private static char dotAi;
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static int scoreHuman;
    private static int scoreAi;
    private static int roundCounter;
    private static int winLength = 3;

    public static void main(String[] args) {
        startNewGame();
    }

    private static void initField(int sizeX, int sizeY) {
        fieldSizeX = sizeX;
        fieldSizeY = sizeY;
        field = new char[fieldSizeY][fieldSizeX];

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    private static void printField() {
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

    private static void startNewGame() {
        while (true) {
            chooseDot();
            playRound();

            System.out.printf("SCORE:  HUMAN  AI\n" +
                    "          %d     %d\n", scoreHuman, scoreAi);

            System.out.print("Play again? (Y/N): ");

            if (!scanner.next().toLowerCase(Locale.ROOT).equals("y")) {
                System.out.println("Goodbye");
                break;
            }
        }
    }

    private static void playRound() {
        System.out.printf("Round %d start\n", ++roundCounter);
        initField(5, 5);
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
        if (checkWin(dot) && dot == dotHuman) {
            System.out.println("You win!");
            scoreHuman++;
            return true;
        } else if (checkWin(dot) && dot == dotAi) {
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
            field[y][x] = dotAi;
            System.out.println("ai made random move");
        }
    }

    private static boolean placeDotInTheMiddle() {
        //place dot in the middle or close to it
        if (isCellValid(fieldSizeY / 2, fieldSizeX / 2)) {
            field[fieldSizeY / 2][fieldSizeX / 2] = dotAi;
            return true;
        }
        return false;
    }

    private static boolean blockPlayer() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellValid(y, x)) {
                    field[y][x] = dotHuman;
                    if (checkWin(dotHuman)) {
                        field[y][x] = dotAi;
                        return true;
                    } else {
                        field[y][x] = DOT_EMPTY;
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
                    field[y][x] = dotAi;
                    if (checkWin(dotAi)) {
                        return true;
                    } else {
                        field[y][x] = DOT_EMPTY;
                    }
                }
            }
        }
        return false;
    }

    private static boolean isCellValid(int y, int x) {
        return x >= 0 && y >= 0 && x < fieldSizeX && y < fieldSizeY && field[y][x] == DOT_EMPTY;
    }

    private static boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == DOT_EMPTY) {
                    return false; //while we can find any empty cell
                }
            }
        }
        System.out.println("DRAW");
        return true;
    }

    private static boolean checkWin(char dot) {
        int winCounter = 0;
        //search for dot
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == dot) { //if cycle found dot
                    int shift1;
                    int shift2;
                    shift1 = x;
                    while (shift1 < fieldSizeX && field[y][shift1] == dot) { //horizontal
                        winCounter++;
                        if (winCounter == winLength) {
                            return true;
                        }
                        shift1++;
                    }

                    winCounter = 0;
                    shift2 = y;
                    while (shift2 < fieldSizeY  && field[shift2][x] == dot) { //vertical
                        winCounter++;
                        if (winCounter == winLength) {
                            return true;
                        }
                        shift2++;
                    }

                    winCounter = 1;
                    shift1 = x + 1;
                    shift2 = y + 1;
                    while (shift1 < fieldSizeX && shift2 < fieldSizeY && field[shift2][shift1] == dot){
                        winCounter++; //diagonal \
                        if (winCounter == winLength) {
                            return true;
                        }
                        shift1++;
                        shift2++;
                    }

                    winCounter = 1;
                    shift1 = x + 1;
                    shift2 = y - 1;
                    while (shift1 < fieldSizeX && shift2 >= 0 && field[shift2][shift1] == dot){
                        winCounter++; //diagonal /
                        if (winCounter == winLength) {
                            return true;
                        }
                        shift1++;
                        shift2--;
                    }
                }
                winCounter = 0;
            }
        }
        return false;
    }
}

