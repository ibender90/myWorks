package ru.geekbrains.practiceGUI;
import java.util.Random;

public class GameEngine {

    public enum Result {
        PLAYER1_WIN, PLAYER2_WIN, COMPUTER_WIN, DRAW;
    }

    private Result whoWin;

    private static GameWindow window;
    private static CustomButton[][] buttonField;
    public static final int MODE_VS_AI = 0;
    public static final int MODE_VS_HUMAN = 1;
    private static int gameMode;

    public static final char DOT_X = 'X';
    public static final char DOT_0 = '0';
    public static final char DOT_EMPTY = '.';

    private final Random random = new Random();


    private char dotHuman1 = DOT_X;
    private char dotHuman2 = DOT_0;
    private char dotAi = DOT_0;
    private int fieldSizeX;
    private int fieldSizeY;
    int scoreHuman1;
    int scoreAi;
    int scoreHuman2;
    private int roundCounter = 1;
    private int winLength;
    private boolean player1Turn = true;

    public static void main(String[] args) {
        window = new GameWindow();
    }
    public GameEngine() {
    }
    public void startNewGame(int gameMode, int fieldSize, int winLength) { //добавть fieldSizeY
        this.gameMode = gameMode;
        fieldSizeX = fieldSize;
        fieldSizeY = fieldSize;
        this.winLength = winLength;
        window.createField(fieldSizeY,fieldSizeX);
        buttonField = window.getButtons();
    }


    public void getResponseFromAI() { // хочу получить ответ на нажатие кнопки
        //сделаю режим для игры против компа
        if(gameCheckHumanVsAI(dotHuman1)){
            showGameOverWindow();
        } else {
            aiTurn();
            if(gameCheckHumanVsAI(dotAi)){
                showGameOverWindow();
            }
        }
    }
    public void checkResult(char dot){
        if(gameCheckHumanVsHuman(dot)){
            showGameOverWindow();
        } else {
            player1Turn = !player1Turn;
        }
    }

    private boolean checkWinAlgorithm(char dot) {
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

    private boolean gameCheckHumanVsAI(char dot) {
        if (checkWinAlgorithm(dot) && dot == dotHuman1) {
            whoWin = Result.PLAYER1_WIN;
            scoreHuman1++;
            roundCounter++;
            return true;
        } else if (checkWinAlgorithm(dot) && dot == dotAi) {
            whoWin = Result.COMPUTER_WIN;
            scoreAi++;
            roundCounter++;
            return true;
        }
        return checkDraw();
    }

    private boolean gameCheckHumanVsHuman(char dot) {
        if (checkWinAlgorithm(dot) && dot == dotHuman1) {
            whoWin = Result.PLAYER1_WIN;
            scoreHuman1++;
            roundCounter++;
            return true;
        } else if (checkWinAlgorithm(dot)&& dot == dotHuman2){
            whoWin = Result.PLAYER2_WIN;
            scoreHuman2++;
            roundCounter++;
            return true;
        }
        return checkDraw();
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
                    buttonField[y][x].dot = dotHuman1;
                    if (checkWinAlgorithm(dotHuman1)) {
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
                    if (checkWinAlgorithm(dotAi)) {
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
                    return false; //while we can find any button unpressed
                }
            }
        }
        whoWin = Result.DRAW;
        roundCounter++;
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
        window.viewRoundCounter();
    }

    private void showGameOverWindow(){
        new GameOverWindow(this);
    }

    public int getScoreHuman1() {
        return scoreHuman1;
    }

    public int getScoreHuman2() {
        return scoreHuman2;
    }

    public int getScoreAi() {
        return scoreAi;
    }

    public int getRoundCounter() {
        return roundCounter;
    }

    public int getGameMode() {
        return gameMode;
    }

    public boolean isPlayer1Turn() {
        return player1Turn;
    }

    public Result getWhoWin() {
        return whoWin;
    }



}
