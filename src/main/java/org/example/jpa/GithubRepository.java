package org.example.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface GithubRepository extends PagingAndSortingRepository<Github, Long> {

    // this method must be in pattern of findBy + repoName
    // Refer https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
    // You can write @Query here to avoid default convention and write any method name
    // like, @Query("SELECT t FROM Thing t WHERE t.foo = ?1 AND t.bar = ?2")
    Github findByRepoName(String repoName);

}
