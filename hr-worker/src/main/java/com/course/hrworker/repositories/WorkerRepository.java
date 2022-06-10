package com.course.hrworker.repositories;

import com.course.hrworker.resources.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
