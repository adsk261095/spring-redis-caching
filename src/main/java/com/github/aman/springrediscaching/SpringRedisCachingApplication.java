package com.github.aman.springrediscaching;

import com.github.aman.springrediscaching.model.Student;
import com.github.aman.springrediscaching.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringRedisCachingApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(SpringRedisCachingApplication.class);
	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		System.out.println("Begin");
		SpringApplication.run(SpringRedisCachingApplication.class, args);
		System.out.println("End");
	}


	@Override
	public void run(String... args) throws Exception {
		studentRepository.show();
		logger.info("Saving users. Current user count is {}.", studentRepository.count());
		Student shubham = new Student("Shubham", 2000);
		Student pankaj = new Student("Pankaj", 29000);
		Student lewis = new Student("Lewis", 550);

		studentRepository.save(shubham);
		studentRepository.save(pankaj);
		studentRepository.save(lewis);
		logger.info("Done saving users. Data: {}.", studentRepository.findAll());
	}
}
