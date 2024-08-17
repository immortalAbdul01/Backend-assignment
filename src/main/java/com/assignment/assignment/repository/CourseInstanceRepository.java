package com.assignment.assignment.repository;

import com.assignment.assignment.model.CourseInstance;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CourseInstanceRepository extends MongoRepository<CourseInstance, String> {
    List<CourseInstance> findByYearAndSemester(int year, int semester);
    List<CourseInstance> findByCourseIdAndYearAndSemester(String courseId, int year, int semester);
}
