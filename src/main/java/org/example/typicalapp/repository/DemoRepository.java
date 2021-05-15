package org.example.typicalapp.repository;

import org.example.typicalapp.dto.SampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DemoRepository extends JpaRepository<SampleEntity, Integer> {

    @Query("SELECT s FROM SampleEntity s WHERE s.name = ?1 ")
    List<SampleEntity> findByName(String name);
}
