package ru.geekbrains.homework9;

public class Homework9 {
    public static void main(String[] args) {
        AbleToJump[] creatures = { //не знаю правильно ли было бы создать один общий интерфейс для этих способностей
                new Cat(2, 10),
                new Human(1, 20),
                new Robot(3, 5)
        };

        Object[] obstacles = {
                new Wall(1),
                new Threadmill(5),
                new Wall(3),
                new Threadmill(6)
        };

        for (int i = 0; i < creatures.length; i++) {
            for (int a = 0; a < obstacles.length; a++)
                if (obstacles[a].getClass().equals(Wall.class)){
                    if(!creatures[i].jump(((Wall)obstacles[a]).getHeight())){
                        break;
                    }
                } else if(obstacles[a].getClass().equals(Threadmill.class)){
                    if(!((AbleToRun)creatures[i]).run(((Threadmill)obstacles[a]).getDistance())){
                        break;
                    }
                }
        }


    }
}
