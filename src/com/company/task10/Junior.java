package src.com.company.task10;

import org.springframework.stereotype.Component;

@Component
public class Junior implements Programmer {
    public String getName() {
        return "junior";
    }
    @Override
    public void doCoding() {
        System.out.println("junior coding");
    }
}
