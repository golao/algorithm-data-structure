package org.golao.test;

import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Created by golao on 2019/6/3.
 */
public class StringLearning {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        String[] ary = new String[list.size()];
        list.toArray(ary);
        System.out.println(Arrays.toString(ary));

        Arrays.asList(ary);
        System.out.println(35 >>> 1);
        StringLearning s = new StringLearning();
        s.start();

    }

    public static void testMap(){
        Map<String,String>  map = new HashMap<>();
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries){
            String key = entry.getKey();
            String value = entry.getValue();
        }
    }
    public void testDateFormat(){
//        DateTimeFormatter
    }


    private volatile int count = 0;
    public void testVolatile1(){
        for (int i = 0; i < 100; i++) {
            count++;
        }
        System.out.println("finish!!!");
    }

    public void start() throws InterruptedException {
        StringLearning s1 = new StringLearning();
        for (int i = 0; i < 100; i++) {
            Thread t1 = new Thread(()->s1.testVolatile1());
            t1.start();
        }

        Thread.sleep(10000);
        System.out.println(s1.count);

    }







}
