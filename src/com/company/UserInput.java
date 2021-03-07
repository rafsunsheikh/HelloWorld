package com.company;

import java.util.Scanner;

public class UserInput {
    private String userNameInput;
    private String passwordInput;

    Scanner scanner = new Scanner(System.in);

    public String getUserName(){
        System.out.print("User Name: ");
        userNameInput = scanner.nextLine();
        return userNameInput;
    }

    public String getPassword(){
        System.out.print("Password: ");
        passwordInput = scanner.nextLine();
        return passwordInput;

    }

}
