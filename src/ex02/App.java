package ex02;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String path = "/join";

        UserController uc = new UserController();
        Method[] methods = uc.getClass().getDeclaredMethods(); //userController에 있는 모든 매서드를 찾아온다

        for (Method m : methods) {
            // System.out.println(m);

            Annotation anno = m.getDeclaredAnnotation(RequestMapping.class);
            RequestMapping rm = (RequestMapping) anno;

            if (rm.uri().equals(path)){
                try {
                    m.invoke(uc);
                } catch (Exception e) {
                    System.out.println("매서드를 호출하다가 오류가 났습니다" + e.getMessage());
                }
            }
        }

    }
}
