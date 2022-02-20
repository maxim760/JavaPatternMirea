package src.com.company.task10;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan
public class MyConfiguration {

    @Bean
    public Junior junior() {
        return new Junior();
    }
    @Bean
    public Middle middle() {
        return new Middle();
    }
    @Bean
    public Senior senior() {
        return new Senior();
    }

}
