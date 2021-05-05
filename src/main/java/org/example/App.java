package org.example;

import org.example.github.GithubProperties;
import org.example.jpa.EventsController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
//@ComponentScan(basePackageClasses = EventsController.class)
@EnableConfigurationProperties(GithubProperties.class)
public class App 
{
    public static void main( String[] args )
{
    System.out.println( "Hello World!" );
    SpringApplication.run(App.class, args);
}
}
