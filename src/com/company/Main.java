//Поиск вхождения каждого слова с предложение
package com.company;
import java.util.*;
import java.lang.String;

public class Main {

    public static void main(String[] args) {
        System.out.print("Введите предложение\n");
        Scanner sentense = new Scanner(System.in);
        String words = sentense.nextLine();
        ArrayList<String> check = new ArrayList<>(words.length());
        System.out.println("Result:");
        for (String word : words.split(" ")) {
            if (check.indexOf(word) == -1) {
                check.add(word);
                System.out.println(Count(word, words) + String.format(" %s", word));
            }
        }
    }

    private static int Count(String word, String words) {
        int cnt = 0;
        for (String el : words.split(" ")) {
            if (el.equals(word)) {
                cnt ++;
            }
        }
        return cnt;
    }

}
//first task done