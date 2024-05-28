package ex01;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String path = "/join";

        UserController uc = new UserController();

        if (path.equals("/login")){
            uc.login();
        }
        if (path.equals("/join")){
            uc.join();
        }

    }
}
