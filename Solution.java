package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collector;

/*
Реализуй метод lengthOfLongestUniqueSubstring таким образом, чтобы он возвращал длину самой длинной подстроки без повторяющихся символов, найденной в строке полученной в качестве параметра.
Например, для строки "a123bcbcqwe" - 6, а для строки "ttttwt" - 2.
Если анализируемая строка пуста или равна null - верни 0.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if (s == null || s.isEmpty())
            return 0;
        Map<String, Integer> map = new HashMap<>();
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < array.length; j++) {
                if (!sb.toString().contains(array[j] + "")) {
                    sb.append(array[j]);
                    map.put(sb.toString(), sb.length());
                } else {
                    map.put(sb.toString(), sb.length());
                    sb = new StringBuilder();
                }
            }
        }
        return map.entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder())).limit(1).mapToInt(Map.Entry::getValue).findAny().getAsInt();
    }
}

