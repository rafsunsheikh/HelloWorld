package com.company;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileHandling {
    File myObj = new File("formatted1.json");

    public void createFile(){
        try{
            if(myObj.createNewFile()){
                System.out.println("New json file created successfully as " + myObj.getName());
            }
            else
                System.out.println("File already exists");
        }
        catch (Exception e)
        {
            System.out.println("An error occoured");
            e.printStackTrace();
        }
    }
    public void fileInformation(){
        if(myObj.exists()){
            System.out.println("File Name: " + myObj.getName());
            System.out.println("Absolute Path: " + myObj.getAbsolutePath());
            System.out.println("Readable: " + myObj.canRead());
            System.out.println("Writable: " + myObj.canWrite());
            System.out.println("File size in Bytes: " + myObj.length());
        }
        else{
            System.out.println("File doesn't exists");
        }
    }
    public void readFromFile(){
        try {
            Scanner scanner = new Scanner(myObj);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                System.out.println("Reading from file: \n" + data);
            }
            scanner.close();
        }
        catch (Exception e)
        {
            System.out.println("Error occured to read file");
            e.printStackTrace();
        }
    }
    public void writeToFile(String S)
    {
        try{
            FileWriter myWriter = new FileWriter("formatted1.json");
            myWriter.write(S);
            myWriter.close();
        }
        catch (Exception e)
        {
            System.out.println("Error occured while writing to the file");
            e.printStackTrace();
        }

    }


}
