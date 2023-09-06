package org.example.app.views;

import java.util.Scanner;

public class UserPasswordUpdateView {

    public String[] getData() {

        Scanner scanner = new Scanner(System.in);

        String title = "Enter user's ID: ";
        System.out.print(title);
        String id = scanner.nextLine().trim();

        title = "Enter new password: ";
        System.out.print(title);
        String password = scanner.nextLine().trim();

        return new String[]{id, password};
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}