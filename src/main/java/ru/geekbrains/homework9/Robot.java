package ru.geekbrains.homework9;

public class Robot implements AbleToJump, AbleToRun{
    private int jumpingHeight;
    private int runningDistance;

    public Robot(int jumpingHeight, int runningDistance) {
        this.jumpingHeight = jumpingHeight;
        this.runningDistance = runningDistance;
    }

    @Override
    public boolean jump(int height) {
        if(height <= jumpingHeight){
            System.out.println("Robot jumped");
            return true;
        } else return false;
    }

    @Override
    public boolean run(int distance) {
        if(distance <= runningDistance){
            System.out.println("Robot ran");
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
