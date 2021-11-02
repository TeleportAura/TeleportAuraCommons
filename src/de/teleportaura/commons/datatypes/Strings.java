package de.teleportaura.commons.datatypes;

import de.teleportaura.commons.util.Preconditions;

public class Strings {

    public static String compose(String[] stringArray, int start, int end){
        Preconditions.checkCondition(start>=0, "The argument \"start\" must be bigger than negative one!");
        Preconditions.checkCondition(end<stringArray.length, "The argument \"end\"" +
                "must be smaller than the length of the supplied array!");
        StringBuilder result = new StringBuilder();
        for(int i0=start;i0<end;i0++) result.append(stringArray[i0]);
        return result.toString();
    }

}
