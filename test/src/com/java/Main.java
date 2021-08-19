package com.java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String path = "./sqltest.txt";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String temp;
            ArrayList<String> list = new ArrayList<>();

            while((temp = br.readLine())!=null){
                list.add(temp);
            }
                System.out.println(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
