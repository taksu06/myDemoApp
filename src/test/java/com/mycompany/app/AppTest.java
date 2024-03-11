package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.Arrays;

public class AppTest extends TestCase {

    public AppTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    public void testCalculateSum() {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(4, 5, 6));
        int param1 = 2;
        int param2 = 3;

        int expectedResult = 27;
        int actualResult = App.calculateSum(list1, list2, param1, param2);

        assertEquals(expectedResult, actualResult);
    }

    public void testCalculateSumWithEmptyLists() {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        int param1 = 2;
        int param2 = 3;

        int expectedResult = 6;
        int actualResult = App.calculateSum(list1, list2, param1, param2);

        assertEquals(expectedResult, actualResult);
    }

    public void testCalculateSumWithNegativeParams() {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(4, 5, 6));
        int param1 = -2;
        int param2 = -3;

        int expectedResult = 27; // (-6) + (-15) - 6
        int actualResult = App.calculateSum(list1, list2, param1, param2);

        assertEquals(expectedResult, actualResult);
    }


    public void testCalculateSumWithLargeNumbers() {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1000000));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(2000000));
        int param1 = 1;
        int param2 = 2;

        int expectedResult = 3000002; // (1000000 + 2000000) + (1 * 2)
        int actualResult = App.calculateSum(list1, list2, param1, param2);

        assertEquals(expectedResult, actualResult);
    }

    public void testCalculateSumWithDifferentListSizes() {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(3, 4, 5));
        int param1 = 2;
        int param2 = 3;

        int expectedResult = 21; // (1 + 2) + (3 + 4 + 5) + (2 * 3)
        int actualResult = App.calculateSum(list1, list2, param1, param2);

        assertEquals(expectedResult, actualResult);
    }
}
