package com.assignment.assignment.service;

import com.assignment.assignment.model.CourseInstance;
import com.assignment.assignment.repository.CourseInstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseInstanceService {

    @Autowired
    private CourseInstanceRepository courseInstanceRepository;

    // Create a new course instance
    public CourseInstance createCourseInstance(CourseInstance courseInstance) {
        return courseInstanceRepository.save(courseInstance);
    }

    // Get instances by year and semester
    public List<CourseInstance> getInstancesByYearAndSemester(int year, int semester) {
        return courseInstanceRepository.findByYearAndSemester(year, semester);
    }

    // Get a specific instance by ID
    public Optional<CourseInstance> getInstanceById(String id) {
        return courseInstanceRepository.findById(id);
    }

    public List<CourseInstance> getInstancesByCourseIdYearAndSemester(String courseId, int year, int semester) {
        return courseInstanceRepository.findByCourseIdAndYearAndSemester(courseId, year, semester);
    }

    public int deleteInstancesByCourseIdYearAndSemester(String courseId, int year, int semester) {
        List<CourseInstance> instances = courseInstanceRepository.findByCourseIdAndYearAndSemester(courseId, year, semester);
        if (!instances.isEmpty()) {
            courseInstanceRepository.deleteAll(instances);
            return instances.size();  // Return the number of deleted instances
        }
        return 0;
    }

    // Get all course instances
    public List<CourseInstance> getAllInstances() {
        return courseInstanceRepository.findAll();
    }
}
