package org.example.jpa;

import java.util.List;
import org.example.github.GithubEvent;

public class DashboardEntry {

    private final Github project;

    private final List<GithubEvent> events;

    public DashboardEntry(Github project, List<GithubEvent> events) {
        this.project = project;
        this.events = events;
    }

    public Github getProject() {
        return project;
    }

    public List<GithubEvent> getEvents() {
        return events;
    }
}