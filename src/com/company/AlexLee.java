package com.company;

import java.util.Scanner;

public class AlexLee {
    private String fullName;
    private String userName;
    private String password;
    private String phone;
    private String email;

    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Full Name: ");
        fullName = scanner.nextLine();

        System.out.print("Username: ");
        userName = scanner.next();

        System.out.print("Password: ");
        password = scanner.next();

        System.out.print("Phone: ");
        phone = scanner.next();

        System.out.print("Email: ");
        email = scanner.next();

        System.out.println("Full Name: " + fullName);
        System.out.println("Username: " + userName);
        System.out.println("Password: " + password);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);

    }

}
