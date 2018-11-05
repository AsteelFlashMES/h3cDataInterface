package com.asteelflash;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableScheduling
//@ComponentScan(basePackages = {"com.asteelflash"})
@EntityScan("com.asteelflash")
@EnableJpaRepositories("com.asteelflash")
public class H3CDataApplication implements ApplicationContextAware {

  public static void main(String[] args) {
    SpringApplication.run(H3CDataApplication.class, args);
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

  }
}
