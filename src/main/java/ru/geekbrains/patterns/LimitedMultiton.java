package ru.geekbrains.patterns;

import java.util.HashMap;
import java.util.Map;

public class LimitedMultiton {
    private static Map instances = new HashMap<>();
    private static LimitedMultiton limitedMultitonInstance = null;

    public enum Enum {
        ONE, TWO, THREE
    }

    public LimitedMultiton getInstance(Enum key){ //same class without enum is called Multiton
        limitedMultitonInstance = (LimitedMultiton) instances.get(key);

        if(limitedMultitonInstance == null){
            limitedMultitonInstance = new LimitedMultiton();
            instances.put(key, limitedMultitonInstance);
        }
        return  limitedMultitonInstance;
    }
}
