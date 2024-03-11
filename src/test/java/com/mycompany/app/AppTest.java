package com.mycompany.app;

import java.util.ArrayList;
import java.util.Arrays;
import com.mycompany.app.AppTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
public class AppTest
        extends TestCase
{
    // following are variables that are to be used given to app as parameters
    private int [] inpArr;
    private ArrayList<Integer> inpArrayList;
    private int threshold;
    private boolean valid;

    //following are expected results::
    private int [] ExpectedinpArr;
    private ArrayList<Integer> ExpectedinpArrayList;
    private int Expectedthreshold;
    private int Expectedvalid;




    public AppTest( String testName )
    {

        super( testName );
    }

    public void testShouldReturnFalseWhenNotValid(){
        inpArrayList= new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        inpArr= new int[]{10,1,2,3};
        valid = false;
        threshold = 2;
        assertFalse(App.firstArraySumGreaterThanSecondArraySumAndAThresholdValueWhenBooleanValidIsTrue(inpArr,inpArrayList,threshold,valid));

    }
    public void testShouldReturnFalseWhenThresholdHigher(){
        inpArrayList= new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        inpArr= new int[]{10,1,2,3};
        valid = true;
        threshold = 200;

        assertFalse(App.firstArraySumGreaterThanSecondArraySumAndAThresholdValueWhenBooleanValidIsTrue(inpArr,inpArrayList,threshold,valid));

    }
    public void testShouldReturnTrue(){
        inpArrayList= new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        inpArr= new int[]{10,1,2,3};
        valid = true;
        threshold = 10;

        assertTrue(App.firstArraySumGreaterThanSecondArraySumAndAThresholdValueWhenBooleanValidIsTrue(inpArr,inpArrayList,threshold,valid));

    }
    public void testNull() {
        inpArrayList= null;
        inpArr = null;
        valid = false;
        threshold = 0;

        assertFalse(App.firstArraySumGreaterThanSecondArraySumAndAThresholdValueWhenBooleanValidIsTrue(inpArr,inpArrayList,threshold,valid));

    }
    public void testWhenBothNotValidAndThresholdHigher(){
        inpArrayList= new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        inpArr= new int[]{10,1,2,3};
        valid = false;
        threshold = 200;

        assertFalse(App.firstArraySumGreaterThanSecondArraySumAndAThresholdValueWhenBooleanValidIsTrue(inpArr,inpArrayList,threshold,valid));


    }
    public void testWhenNotValidAndThresholdHigherAndSecondArrayHigher(){
        inpArrayList= new ArrayList<Integer>(Arrays.asList(1,2,3,4,100));
        inpArr= new int[]{10,1,2,3};
        valid = false;
        threshold = 200;

        assertFalse(App.firstArraySumGreaterThanSecondArraySumAndAThresholdValueWhenBooleanValidIsTrue(inpArr,inpArrayList,threshold,valid));


    }
    public void testShouldReturnFalseSecondArrhigher(){
        inpArrayList= new ArrayList<Integer>(Arrays.asList(1,2,3,4,250));
        inpArr= new int[]{10,1,2,3};
        valid = true;
        threshold = 2;

        assertFalse(App.firstArraySumGreaterThanSecondArraySumAndAThresholdValueWhenBooleanValidIsTrue(inpArr,inpArrayList,threshold,valid));
    }

    public static Test suite()
    {  return new TestSuite( AppTest.class );
    }


}