package com.github.aman.springrediscaching.resource;

import com.github.aman.springrediscaching.model.Student;
import com.github.aman.springrediscaching.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StudentResource {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private StudentRepository studentRepository;

    //get request
    @Cacheable(value = "student", key="#id", unless = "#result.followers < 0")
    @GetMapping(value = "/getStudentById")
    public Optional<Student> getStudent(@RequestParam(value="id") String id){
        logger.info("Getting student with id: " + id);
        return studentRepository.findById(Integer.parseInt(id));
    }

    //add request
    @CachePut(value="student", key="#result.id")
    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student){
        Student s = studentRepository.save(student);
        logger.info("Adding student with id: " + s.getId());
        System.out.println(s);
        return s;
    }

    //delete request
    @CacheEvict(value = "student", key="#id")
    @DeleteMapping("/deleteStudentById")
    public void deleteUserByID(@RequestParam(value="id") int id) {
        logger.info("deleting student with id {}", id);
        studentRepository.deleteById(id);
    }
}
