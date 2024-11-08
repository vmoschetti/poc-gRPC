package br.com.poc.app2;

import br.com.poc.app2.coreH2.MockerService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App2Application {

    @Autowired
    public MockerService mockerService;

    public static void main(String[] args) {
        SpringApplication.run(App2Application.class, args);
    }


    @PostConstruct
    public void init() {
        mockerService.loadTable();
    }

}
