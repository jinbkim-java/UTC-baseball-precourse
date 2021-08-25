package utils;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Validate {
    public static boolean hasWrongSize(String userInput, int size){
        if (userInput.length() != size)
            return true;
        return false;
    }
    public static boolean validateOnlyNumber(String userInput){
        char tmp;
        for(int i=0; i<userInput.length(); i++) {
            tmp = userInput.charAt(i);
            if (tmp < '0' || tmp > '9')
                return false;
        }
        return true;
    }
    public static boolean hasParticularNumber(String userInput, int particularNum){
        return Stream.of(userInput.split(""))
                .map(n -> Integer.parseInt(n))
                .anyMatch(n -> n == particularNum);
    }
    public static boolean hasOverlap(String userInput, int size){
        Set<Integer> setBalls = Stream.of(userInput.split(""))
                .map(n -> Integer.parseInt(n))
                .collect(Collectors.toSet());
        if (setBalls.size() != size)
            return true;
        return false;
    }
}
