package org.example.jpa;

import javax.persistence.*;

// Create this class and add jpa and h2 starters and the table to automatically created for you
@Entity
public class Github {

    @Id
    @GeneratedValue()
    private Long id ;

    @Column(length = 50)
    private String orgName;

    @Column(unique = true)
    private String repoName;

    public Github(){

    }
    public Github(String orgName, String repoName){
        this.orgName = orgName;
        this.repoName = repoName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public String toString(){
        return "Github{id="+id+",orgName="+orgName+",repoName"+repoName+"}";
    }
}
