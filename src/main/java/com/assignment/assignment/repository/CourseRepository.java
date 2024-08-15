// CourseRepository.java
package com.assignment.assignment.repository;

import com.assignment.assignment.model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course, String> {
}