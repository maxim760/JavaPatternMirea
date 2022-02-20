package src.com.company.task10;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyConfiguration {

    @Bean
    @Scope("prototype")
    public Programmer programmer() {
        return new Junior();
    }

    @Bean
    public Client client(Programmer programmer) {
        Client client = new Client();
        client.setProgrammer(programmer);
        return client;
    }


}
