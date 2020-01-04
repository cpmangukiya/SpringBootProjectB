package org.example.github;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class GithubClient {

    private static final String EVENT_URL = "https://api.github.com/repos/{owner}/{repo}/issues/events";

    private RestTemplate restTemplate;

    public GithubClient(RestTemplateBuilder restTemplateBuilder, GithubProperties githubProperties, MeterRegistry meterRegistry) {
        this.restTemplate = restTemplateBuilder
                .additionalInterceptors(new GithubAppTokenInterceptor(githubProperties.getToken()))
                .additionalInterceptors(new MetricsInterceptor(meterRegistry))
                .build();
    }

    /**
     * @param orgName
     * @param repoName
     * @return
     */
    public ResponseEntity<GithubEvent[]> fetchEvents(String orgName, String repoName) {
        return this.restTemplate.getForEntity(EVENT_URL, GithubEvent[].class, orgName, repoName);
    }

    public List<GithubEvent> fetchEventsList(String orgName, String repoName) {
        return Arrays.asList(this.fetchEvents(orgName, repoName).getBody());
    }

    private static class GithubAppTokenInterceptor implements ClientHttpRequestInterceptor {

        private final String token;

        GithubAppTokenInterceptor (String token) {
            this.token = token;
        }

        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
            if(StringUtils.hasText(this.token)){
                byte[] basicAuth = this.token.getBytes(StandardCharsets.UTF_8);
                request.getHeaders().set(HttpHeaders.AUTHORIZATION,
                        "Basic "+ Base64Utils.encodeToString(basicAuth));
            }
            return execution.execute(request, body);
        }
    }

    private static class MetricsInterceptor implements ClientHttpRequestInterceptor {

        private final AtomicInteger gauge;

        public MetricsInterceptor(MeterRegistry meterRegistry) {
            this.gauge = meterRegistry.gauge("github.ratelimit.remaining", new AtomicInteger(60));
        }

        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
            ClientHttpResponse response = execution.execute(request, body);
            this.gauge.set(Integer.parseInt(response.getHeaders().getFirst("X-RateLimit-Remaining")));
            return response;
        }
    }
}
