package org.example.jpa;

import org.example.github.GithubClient;
import org.example.github.GithubEvent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


/**
 * This controller is to fetch event from Github
 */
@Controller
public class EventsController {

    private final GithubRepository githubRepository;

    private final GithubClient githubClient;

    public EventsController(GithubRepository githubRepository, GithubClient githubClient) {
        this.githubRepository = githubRepository;
        this.githubClient = githubClient;
    }

    /**
     * @param repoName
     * @return
     */
    @GetMapping("/events/{repoName}")
    @ResponseBody
    public GithubEvent[] fetchEvents(@PathVariable String repoName) {
        try {
            Github github = this.githubRepository.findByRepoName(repoName);
            return this.githubClient.fetchEvents(github.getOrgName(), github.getRepoName()).getBody();
        } catch (Exception exception){
            return new GithubEvent[0];
        }

    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("projects", this.githubRepository.findAll());
        return "admin";
    }

    @GetMapping("/")
    public String dashboard(Model model) {
        Iterable<Github> repositoryAll = this.githubRepository.findAll();

        List<DashboardEntry> collect = StreamSupport.stream(repositoryAll.spliterator(), true)
                .map(p -> new DashboardEntry(p, this.githubClient.fetchEventsList(p.getOrgName(), p.getRepoName())))
                .collect(Collectors.toList());

        model.addAttribute("entries", collect);

        return "dashboard";
    }
}
