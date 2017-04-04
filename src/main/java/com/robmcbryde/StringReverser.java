package com.robmcbryde;

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