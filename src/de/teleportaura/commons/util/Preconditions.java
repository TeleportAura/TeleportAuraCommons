package de.teleportaura.commons.util;

import java.util.Locale;

public class Preconditions {

    public static void checkCondition(boolean condition, String errorMessage, Object... args){
        if(condition) return;
        throw new IllegalConditionError(String.format(Locale.ROOT, errorMessage, args));
    }

    static class IllegalConditionError extends Error{

        IllegalConditionError(){
            super();
        }

        IllegalConditionError(String message){
            super(message);
        }

    }

}
