package com.github.aman.springrediscaching.resource;

import com.github.aman.springrediscaching.model.Student;
import com.github.aman.springrediscaching.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class StudentResource {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private StudentRepository studentRepository;

    @Cacheable(value = "student", key="#id", unless = "#result.followers < 0")
    @GetMapping(value = "/getStudentById/{id}")
    public Optional<Student> getStudent(@PathVariable String id){
        logger.info("Getting student with is: " + id);
        return studentRepository.findById(Integer.parseInt(id));
    }
}
