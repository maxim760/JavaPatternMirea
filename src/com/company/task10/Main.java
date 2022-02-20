package src.com.company.task10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        Programmer junior = context.getBean(Junior.class);
        Programmer middle = context.getBean(Middle.class);
        Programmer senior = context.getBean(Senior.class);
        Programmer[] list = {junior, middle, senior};
        Arrays.asList(list).forEach(item -> item.doCoding());
    }
}
