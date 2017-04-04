package com.robmcbryde;

public class FahrenheitCelsiusConverter {

    public static int toFahrenheit(int i) {
        double value = (double)i;
        return (int)(value * 9.0 / 5.0) + 32;
    }

    public static int toCelsius(int i) {

        double step1 = i - 32;
        double step2 = 9.0 / 5.0;
        double answer = step1 / step2;
        return (int)Math.ceil(answer);
    }
}
