package com.github.aman.springrediscaching.repository;

import com.github.aman.springrediscaching.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    default public void show(){
        System.out.println("from studentRepository");
    }
}
