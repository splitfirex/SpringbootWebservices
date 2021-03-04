package io.splitfirex.commons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebServiceRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebServiceRestApplication.class, args);//init the context
    }

    // Defining avaiable URL endpoints
    @Bean(name = "permitUrl")
    public String[] getPermitUrl() {
        return new String[]{"/v2/api-docs", "/h2-console/**", "/authenticate"};
    }

}
