package com.company;

import java.util.Scanner;

public class StudentInput {
    private int studentIdInput;

    Scanner scanner = new Scanner(System.in);

    public int getStudentId(){
        System.out.print("Student ID: ");
        studentIdInput = scanner.nextInt();
        return studentIdInput;
    }

}
