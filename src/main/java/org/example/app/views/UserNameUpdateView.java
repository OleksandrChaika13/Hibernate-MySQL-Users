package org.example.app.views;

import java.util.Scanner;

public class UserNameUpdateView {

    public String[] getData() {

        Scanner scanner = new Scanner(System.in);

        String title = "Enter user's ID: ";
        System.out.print(title);
        String id = scanner.nextLine().trim();

        title = "Enter new username: ";
        System.out.print(title);
        String userName = scanner.nextLine().trim();

        return new String[]{id, userName};
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}