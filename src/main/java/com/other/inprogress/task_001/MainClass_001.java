package com.other.inprogress.task_001;

import java.util.*;

public class MainClass_001 {


//    Given a dictionary of words, come up with a function to check if the given string can be segmented out of the dictionary.
//    Example-
//    Dictionary = ["apple", "pine", "sweet"]
//
//    input1 = 'sweetapple' - true
//    input2= 'pineapple' - true
//    input3= 'greenapple' - false


    public static void main(String[] args) {
        String[] dictionary = {"apple", "pine", "sweet"};

        System.out.println(check(dictionary, "sweetapple"));
        System.out.println(check(dictionary, "pineapple"));
        System.out.println(check(dictionary, "greenapple"));

    }

    private static boolean check(String[] dictionary, String input) {
        if (input.isEmpty()) {
            return true;
        }
        for (int i = 0; i < dictionary.length; i++) {
            String variant = dictionary[i];
            if (input.startsWith(variant)) {
                String newInput = input.substring(variant.length(), input.length());
                List<String> newDict = new ArrayList<>(List.of(dictionary));
                newDict.remove(variant);
                if (check(newDict.toArray(new String[newDict.size()]), newInput)) {
                    return true;
                }
            }
        }
        return false;
    }


}
