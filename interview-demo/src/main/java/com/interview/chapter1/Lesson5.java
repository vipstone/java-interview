package com.interview.chapter1;

public class Lesson5 {
    public static void main(String[] args) {

        /*
         * try-catch-finally 基本使用
         */
//        try {
//            int i = 10 / 0;
//        } catch (ArithmeticException e) {
//            System.out.println(e);
//        } finally {
//            System.out.println("finally");
//        }

        /*
         * 多 catch 使用
         */
//        try {
//            int i = Integer.parseInt(null);
//        } catch (ArithmeticException ae) {
//            System.out.println("ArithmeticException");
//        } catch (NullPointerException ne) {
//            System.out.println("NullPointerException");
//        } catch (Exception e) {
//            System.out.println("Exception");
//        }

        /*
         * 使用 try-catch 处理业务逻辑
         */
//        // 使用 com.alibaba.fastjson
//        JSONArray array = new JSONArray();
//        String jsonStr = "{'name':'laowang'}";
//        try {
//            array = JSONArray.parseArray(jsonStr);
//        } catch (Exception e) {
//            array.add(JSONObject.parse(jsonStr));
//        }
//        System.out.println(array.size());

        // 使用 com.alibaba.fastjson
//        JSONArray array = new JSONArray();
//        String jsonStr = "{'name':'laowang'}";
//        if (null != jsonStr && !jsonStr.equals("")) {
//            String firstChar = jsonStr.substring(0, 1);
//            if (firstChar.equals("{")) {
//                array.add(JSONObject.parse(jsonStr));
//            } else if (firstChar.equals("[")) {
//                array = JSONArray.parseArray(jsonStr);
//            }
//        }
//        System.out.println(array.size());
//        try {
//            array = JSONArray.parseArray(jsonStr);
//        } catch (Exception e) {
//            array.add(JSONObject.parse(jsonStr));
//        }
//        System.out.println(array.size());

        /*
         * Integer.parseInt 和 Double.parseDouble 的异常类型
         */
//        Integer.parseInt(null);
//        Double.parseDouble(null);

        /*
         * try-with-resources 和 multiple catch
         */
//        try (FileReader fileReader = new FileReader("");
//             FileWriter fileWriter = new FileWriter("")) { // Try-with-resources
//            System.out.println("try");
//        } catch (IOException | NullPointerException e) { // Multiple catch
//            System.out.println(e);
//        }

        /*
         * finally 也发生的异常
         */
//        try {
//            System.out.println("try");
//        } catch (Exception e) {
//            System.out.println("catch");
//        } finally {
//            int k = 3 / 0;
//            System.out.println("finally");
//        }
//        System.out.println("main");

        /*
         * try/finally
         */
//        try {
//            int i = 10 / 0;
//        } finally {
//            System.out.println("last");
//        }

    }
}
