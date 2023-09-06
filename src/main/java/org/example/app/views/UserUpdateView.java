package org.example.app.views;

import java.util.Scanner;

public class UserUpdateView {

    public String[] getData() {

        Scanner scanner = new Scanner(System.in);

        String title = "Enter user's ID: ";
        System.out.print(title);
        String id = scanner.nextLine().trim();

        String title1 = "Enter user name: ";
        System.out.print(title1);
        String userName = scanner.nextLine().trim();

        title = "Enter email: ";
        System.out.print(title);
        String email = scanner.nextLine().trim();

        title = "Enter password: ";
        System.out.print(title);
        String password = scanner.nextLine().trim();

        return new String[]{id, userName, email, password};
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}