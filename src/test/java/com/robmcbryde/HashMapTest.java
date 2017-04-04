package com.robmcbryde;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class HashMapTest {

    Map<String, String> map;
    private String expectedKey;
    private String expectedValue;

    @Before
    public void setUp() throws Exception {
       map = new HashMap<>();
        expectedKey = "testKey";
        expectedValue = "testValue";

        map.put(expectedKey, expectedValue);
    }

    @Test
    public void testCanPutIntoHashmap() throws Exception {
        assertEquals(1, map.size());
        assertEquals(expectedValue, map.get(expectedKey));
    }

    @Test
    public void testPutSecondObjectInotHashmap_withSameKey_overridesOriginalObject() throws Exception {
        String updatedValue = "updatedValue";
        map.put(expectedKey, updatedValue);

        Object actual = map.get(expectedKey);

        assertEquals(1, map.size());
        assertEquals(updatedValue, actual);
    }

    @Test
    public void testClear_removesAllFromMap() throws Exception {
        String updatedValue = "updatedValue";
        map.put(expectedKey, updatedValue);

        map.clear();

        assertEquals(0, map.size());
    }

    @Test
    public void testNullCanBeUsedAsMapKey() throws Exception {
        String nullValue = "nullValue";
        map.put(null, nullValue);

        Object actual = map.get(null);

        assertEquals(2, map.size());
        assertEquals(nullValue, actual);
    }
}