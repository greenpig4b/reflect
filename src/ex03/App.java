package ex03;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();

        DispatcherServlet ds = new DispatcherServlet();
        ds.startApplication(path);
    }
}