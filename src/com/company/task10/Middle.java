package src.com.company.task10;

import org.springframework.stereotype.Component;

@Component
public class Middle implements Programmer {
    public String getName() {
        return "middle";
    }
    @Override
    public void doCoding() {
        System.out.println("middle coding");
    }
}
