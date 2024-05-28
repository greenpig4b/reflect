package ex03;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class DispatcherServlet {
    public void startApplication(String url) throws Exception {
        Set<Object> ioc = componentScan("ex03");
        findUri(ioc, url);
    }

    private void findUri(Set<Object> ioc, String uri) throws Exception {
        for (Object ob : ioc){
            Method[] methods = ob.getClass().getDeclaredMethods();

            for (Method mt : methods) {
                Annotation anno = mt.getDeclaredAnnotation(RequestMapping.class);
                RequestMapping rm = (RequestMapping) anno;
                if (rm.uri().equals(uri)) {
                    mt.invoke(ob);
                }
            }
        }
    }

    private Set<Object> componentScan(String pkg) throws URISyntaxException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 1. 컴퍼넌트 스캔 (컨트롤러를 메모리 new)
        Set<Object> ioc = new HashSet<>(); // 싱글톤으로 관리됨

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL packageUrl = classLoader.getResource(pkg);
        File packageDirectory = new File(packageUrl.toURI());

        for (File file : packageDirectory.listFiles()){
            // App.class
            String className = pkg+"."+file.getName().replace(".class", "");
            // ch03.App
            System.out.println(className);

            Class cls = Class.forName(className);

            if(cls.isAnnotationPresent(Controller.class)){
                Object instance = cls.newInstance();
                ioc.add(instance);
            }
        }
        return ioc;
    }
}
