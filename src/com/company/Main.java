package com.company;

import com.google.gson.Gson;

public class Main {

    public static void main(String[] args) {

        AlexLee a = new AlexLee();
        a.input();

        Gson json = new Gson();

        String response = json.toJson(a);

        System.out.println(response);

    }
}
