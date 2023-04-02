package com.example.trains.repository;

import com.example.trains.entity.Run;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RunRepository extends JpaRepository<Run, Integer>{
}
