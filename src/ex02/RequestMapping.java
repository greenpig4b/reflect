package ex02;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
* @ JVM이 해석가능한 주석
* */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME) // JVM 실행시 확인함
public @interface RequestMapping {
    String uri();
}
