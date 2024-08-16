package com.assignment.assignment.repository;

import com.assignment.assignment.model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface CourseRepository extends MongoRepository<Course, String> {

    Optional<Course> findByCode(String code);

    // Define the deleteByCode method
    @Query(value = "{ 'code': ?0 }", delete = true)
    void deleteByCode(String code);
}
