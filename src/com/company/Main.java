package com.company;

import com.google.gson.Gson;

public class Main {

    public static void main(String[] args)  {

        AlexLee a = new AlexLee();
        a.input();

        Gson json = new Gson();

        String response = json.toJson(a);

        System.out.println("Created json response: \n" + response);

        FileHandling file1 = new FileHandling();

        file1.createFile();
        file1.fileInformation();
        file1.writeToFile(response);
        file1.readFromFile();

    }
}
