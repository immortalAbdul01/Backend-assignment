package com.assignment.assignment.service;

import com.assignment.assignment.model.Course;
import com.assignment.assignment.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // Create a new course
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    // Get all courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Get a course by code
    public Optional<Course> getCourseByCode(String code) {
        return courseRepository.findByCode(code);
    }

    // Delete a course by code
    public void deleteCourseByCode(String code) {
        courseRepository.deleteByCode(code);
    }
}
