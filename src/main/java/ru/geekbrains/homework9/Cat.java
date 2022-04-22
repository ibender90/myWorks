package ru.geekbrains.homework9;

public class Cat implements AbleToRun, AbleToJump{
    private int jumpingHeight;
    private int runningDistance;

    public Cat(int jumpingHeight, int runningDistance) {
        this.jumpingHeight = jumpingHeight;
        this.runningDistance = runningDistance;
    }

    @Override
    public boolean jump(int height) {
        if(height <= jumpingHeight){
            System.out.println("Cat jumped");
            return true;
        } else return false;
    }

    @Override
    public boolean run(int distance) {
        if(distance <= runningDistance){
            System.out.println("Cat ran");
            return true;
        }
        else return false;
    }

    public int getJumpingHeight() {
        return jumpingHeight;
    }

    public int getRunningDistance() {
        return runningDistance;
    }
}
