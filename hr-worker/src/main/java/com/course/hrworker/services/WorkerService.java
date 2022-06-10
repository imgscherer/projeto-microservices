package com.course.hrworker.services;

import com.course.hrworker.resources.entities.Worker;
import com.course.hrworker.repositories.WorkerRepository;
import com.course.hrworker.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository repository;

    public List<Worker> findAll(){
        return repository.findAll();
    }

    public Worker findById(Long id){
        Optional<Worker> worker = repository.findById(id);
        return worker.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
