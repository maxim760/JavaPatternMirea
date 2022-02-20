package src.com.company.task10;

import org.springframework.stereotype.Component;

@Component
public class Senior implements Programmer {
    public String getName() {
        return "senior";
    }
    @Override
    public void doCoding() {
        System.out.println("senior coding");
    }
}