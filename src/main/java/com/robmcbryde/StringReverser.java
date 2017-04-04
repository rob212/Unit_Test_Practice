package com.robmcbryde;

/**
 * Created by robertmcbryde on 18/02/2017.
 */
public class StringReverser {

    public static String reverse(String s ) {
        if (s == null) {
            throw new IllegalArgumentException("Null value passed in as argument");
        } else if (s.isEmpty()){
            return "";
        }
        StringBuilder word = new StringBuilder(s);
        return word.reverse().toString();
    }
}
