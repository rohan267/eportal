package com.solactive.eportal;

import static org.springframework.boot.SpringApplication.run;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.solactive.eportal.dao")
@EntityScan("com.solactive.eportal.model")
@SpringBootApplication
public class EportalApplication
{

   public static void main(String[] args)
   {
      run(EportalApplication.class, args);
   }

}
