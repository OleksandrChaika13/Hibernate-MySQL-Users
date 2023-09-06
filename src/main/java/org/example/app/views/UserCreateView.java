package org.example.app.views;

import java.util.Scanner;

public class UserCreateView {

    public String[] getData() {

        Scanner scanner = new Scanner(System.in);

        String title = "Enter user name: ";
        System.out.print(title);
        String userName = scanner.nextLine().trim();

        title = "Enter email: ";
        System.out.print(title);
        String email = scanner.nextLine().trim();

        title = "Enter password: ";
        System.out.print(title);
        String password = scanner.nextLine().trim();

        return new String[]{userName, email, password};
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}