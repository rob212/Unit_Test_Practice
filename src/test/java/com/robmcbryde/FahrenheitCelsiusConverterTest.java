package com.robmcbryde;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertEquals;

/**
 * Created by robertmcbryde on 19/02/2017.
 */
@RunWith(JUnitParamsRunner.class)
public class FahrenheitCelsiusConverterTest {

    private static final double DELTA = 1e-15;

    private static final Object[] getTemps() {
        return $(
            $(32, 0),
            $(98, 37),
            $(212, 100)
        );
    }

    @Test
    @Parameters(method = "getTemps")
    public void shouldConvertCelsiusToFahrenheit(int fahrenheit, int celsius) {
        assertEquals(fahrenheit, FahrenheitCelsiusConverter.toFahrenheit(celsius), DELTA);
    }

    @Test
    @Parameters(method = "getTemps")
    public void shouldConvertFahrenheitToCelsius(int fahrenheit, int celsius) {
        assertEquals(celsius, FahrenheitCelsiusConverter.toCelsius(fahrenheit), DELTA);
    }
}