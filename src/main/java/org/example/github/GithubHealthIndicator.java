package org.example.github;

import org.slf4j.ILoggerFactory;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.function.DoubleToIntFunction;
import java.util.logging.Logger;

@Component
public class GithubHealthIndicator implements HealthIndicator {

    private final GithubClient githubClient;

    public GithubHealthIndicator(GithubClient githubClient) {
        this.githubClient = githubClient;
    }

    @Override
    public Health getHealth(boolean includeDetails) {
        // This method works
        try {
            ResponseEntity<GithubEvent[]> responseEntity = this.githubClient.fetchEvents("spring-projects","spring-boot");
            if(responseEntity.getStatusCode().is2xxSuccessful()){
                System.out.println("F Success");
                return Health.up().build();
            } else {
                System.out.println("F Fail1");
                return Health.down().build();
            }
        } catch (Exception exception) {
            System.out.println("F Fail2");
            exception.printStackTrace();
            return Health.down().build();
        }
    }

    @Override
    public Health health() {
        // Not sure about this method
        try {
            ResponseEntity<GithubEvent[]> responseEntity = this.githubClient.fetchEvents("cpmangukiya","cpm-mysite");
            if(responseEntity.getStatusCode().is2xxSuccessful()){
                System.out.println("S Success");
                return Health.up().build();
            } else {
                System.out.println("S Fail1");
                return Health.down().build();
            }
        } catch (Exception exception) {
            System.out.println("S Fail2");
            exception.printStackTrace();
            return Health.down().build();
        }
    }
}
