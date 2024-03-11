package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App {
    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
            String inputParam1 = req.queryParams("inputList");
            java.util.Scanner sc1 = new java.util.Scanner(inputParam1);
            sc1.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
            while (sc1.hasNext()) {
                int value = Integer.parseInt(sc1.next().replaceAll("\\s", ""));
                inputList.add(value);
            }

            String inputParam2 = req.queryParams("inputList2");
            java.util.Scanner sc2 = new java.util.Scanner(inputParam2);
            sc2.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
            while (sc2.hasNext()) {
                int value = Integer.parseInt(sc2.next().replaceAll("\\s", ""));
                inputList2.add(value);
            }

            int param1 = Integer.parseInt(req.queryParams("input2AsInt").replaceAll("\\s", ""));
            int param2 = Integer.parseInt(req.queryParams("valid").replaceAll("\\s", ""));

            int result = calculateSum(inputList, inputList2, param1, param2);

            Map<String, Object> map = new HashMap<>();
            map.put("result", result);
            return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute", (rq, rs) -> {
            Map<String, Object> map = new HashMap<>();
            map.put("result", "not computed yet!");
            return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; // Return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static int calculateSum(ArrayList<Integer> list1, ArrayList<Integer> list2, int param1, int param2) {
        int sum = 0;

        // Calculate sum of elements in list1
        for (int num : list1) {
            sum += num;
        }

        // Calculate sum of elements in list2
        for (int num : list2) {
            sum += num;
        }

        // Perform computation with params
        sum += param1 * param2;

        return sum;
    }
}
