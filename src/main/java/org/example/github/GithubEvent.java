package org.example.github;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;

public class GithubEvent {

    private final String type;

    private final OffsetDateTime offsetDateTime;

    private final Actor actor;

    private final Issue issue;

    @JsonCreator
    public GithubEvent(@JsonProperty("event") String type,
                       @JsonProperty("created_at") OffsetDateTime offsetDateTime,
                       @JsonProperty("actor") Actor actor,
                       @JsonProperty("issue") Issue issue){
        this.type = type;
        this.offsetDateTime = offsetDateTime;
        this.actor = actor;
        this.issue = issue;
    }

    public String getType() {
        return type;
    }

    public OffsetDateTime getOffsetDateTime() {
        return offsetDateTime;
    }

    public Actor getActor() {
        return actor;
    }

    public Issue getIssue() {
        return issue;
    }
}
