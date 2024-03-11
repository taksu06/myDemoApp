package com.mycompany.app;


import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;


public class App
{
    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
            //System.out.println(req.queryParams("input1"));
            //System.out.println(req.queryParams("input2"));

            String inputArr1 = req.queryParams("inputParam1Arr");
            java.util.Scanner sc1 = new java.util.Scanner(inputArr1);
            sc1.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
            while (sc1.hasNext())
            {
                int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
                inputList.add(value);
            }
            System.out.println(inputList);

            String inputArr2 = req.queryParams("inputList2");
            java.util.Scanner sc2 = new java.util.Scanner(inputArr2);
            sc2.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
            while (sc2.hasNext())
            {
                int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
                inputList2.add(value);
            }
            System.out.println(inputList2);

            int[] inputParam1Arr = new int[inputList.size()];
            for(int i=0; i < inputParam1Arr.length ;i++){
                inputParam1Arr[i] = inputList.get(i);
            }

            String input2 = req.queryParams("input2AsInt").replaceAll("\\s","");
            if(input2.equals("")) //is empty
                input2 = "0"; // set to zero
            int input2AsInt = Integer.parseInt(input2);

            String inputBool = req.queryParams("valid").replaceAll("\\s","");
            if(inputBool.equals("")) //is empty
                inputBool = "0"; // set to zero

            int inputBoolAsInt = Integer.parseInt(inputBool);

            boolean valid = false;
            if( inputBoolAsInt == 1) valid = true;

            boolean result = App.firstArraySumGreaterThanSecondArraySumAndAThresholdValueWhenBooleanValidIsTrue(inputParam1Arr,inputList2, input2AsInt,valid);

            Map map = new HashMap();
            map.put("result", result);
            return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
                (rq, rs) -> {
                    Map map = new HashMap();
                    map.put("result", "not computed yet!");
                    return new ModelAndView(map, "compute.mustache");
                },
                new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static boolean firstArraySumGreaterThanSecondArraySumAndAThresholdValueWhenBooleanValidIsTrue
            (int [] ar1, ArrayList<Integer> arayList, int threshold, boolean valid){
        if(ar1 == null || arayList == null) return false;
        if(valid == true) {
            int sum1 = 0;
            for (int i = 0; i < ar1.length; i++) {
                sum1 += ar1[i];
            }
            int sum2 = 0;
            for (int i = 0; i < arayList.size(); i++) {
                sum2 += arayList.get(i);
            }
            if(sum2>=sum1) return false;
            if(threshold >= sum1) return false;
            return true;
        } else{
            return false;
        }


    }



}