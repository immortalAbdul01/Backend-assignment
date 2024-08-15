// CourseInstanceService.java
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

    public CourseInstance createCourseInstance(CourseInstance courseInstance) {
        return courseInstanceRepository.save(courseInstance);
    }

    public List<CourseInstance> getInstancesByYearAndSemester(int year, int semester) {
        return courseInstanceRepository.findByYearAndSemester(year, semester);
    }

    public Optional<CourseInstance> getInstanceById(String id) {
        return courseInstanceRepository.findById(id);
    }

    public void deleteCourseInstance(String id) {
        courseInstanceRepository.deleteById(id);
    }
}