package org.example.app.utils;

public final class Constants {

    public final static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    public final static String DB_URL = "jdbc:mysql://localhost:3306/hibernate_db?";
    public final static String DB_USER = "root";

    public final static String USERNAME_REGEX = "^[a-zA-Z0-9]+$";
    public final static String WRONG_USERNAME_REGEX = "Wrong username input.";

    public final static String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$";
    public final static String WRONG_PASSWORD_MSG = "Wrong password input.";

    public final static String EMAIL_RGX = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    public final static String WRONG_EMAIL_MSG = "Wrong email input.";

    public final static String ID_RGX = "^[1-9]$";
    public final static String WRONG_ID_MSG = "Wrong id input.";

    public final static String DATA_ABSENT_MSG = "\n>> No data!";
    public final static String DATA_INSERT_MSG = "\n>> Created.";
    public final static String DATA_UPDATE_MSG = "\n>> Updated.";
    public final static String DATA_DELETE_MSG = "\n>> Deleted.";

    public final static String APP_CLOSE_MSG = "\n>> App closed.";
    public final static String INPUT_REQ_MSG = "Input required.";
    public final static String INCORRECT_VALUE_MSG = ">> Incorrect value! Try again.";
    public final static String ID_NO_EXISTS_MSG = "\n>> There is no such ID.";
}