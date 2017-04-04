package com.robmcbryde;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;

/**
 * Created by robertmcbryde on 18/02/2017.
 */
@RunWith(JUnitParamsRunner.class)
public class StringReverserTest {

    private static final Object[] getWords() {
        return $(
            $("cat", "tac"),
            $("mat", "tam"),
            $("word space", "ecaps drow"),
            $("word@", "@drow")
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullInput_throwsIllegalArgumentException() throws Exception {
    StringReverser.reverse(null);
    }

    @Test
    public void testEmptyStringInput_returnsEmptyString() throws Exception {
        String actual =StringReverser.reverse("");
        assertEquals("", actual);
    }

    @Test()
    @Parameters(method = "getWords")
    public void testReverseSimpleWord(String word, String expected) throws Exception {
        String actual = StringReverser.reverse(word);
        assertEquals(expected, actual);
    }
}