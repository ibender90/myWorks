package ru.geekbrains.homework9;

public class Human implements AbleToJump, AbleToRun{
    private int jumpingHeight;
    private int runningDistance;

    public Human(int jumpingHeight, int runningDistance) {
        this.jumpingHeight = jumpingHeight;
        this.runningDistance = runningDistance;
    }

    @Override
    public boolean jump(int height) {
        if(height <= jumpingHeight){
            System.out.println("Human jumped");
            return true;
        } else return false;
    }

    @Override
    public boolean run(int distance) {
        if(distance <= runningDistance){
            System.out.println("Human ran");
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
