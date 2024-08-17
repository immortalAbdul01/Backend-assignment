package com.assignment.assignment.controller;

import com.assignment.assignment.model.CourseInstance;
import com.assignment.assignment.service.CourseInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/instances")
public class CourseInstanceController {

    @Autowired
    private CourseInstanceService courseInstanceService;

    // Create a new course instance
    @PostMapping
    public ResponseEntity<CourseInstance> createCourseInstance(@Valid @RequestBody CourseInstance courseInstance) {
        CourseInstance savedInstance = courseInstanceService.createCourseInstance(courseInstance);
        return ResponseEntity.ok(savedInstance);
    }

    // Get instances by year and semester
    @GetMapping("/{year}/{semester}")
    public List<CourseInstance> getInstancesByYearAndSemester(@PathVariable int year, @PathVariable int semester) {
        return courseInstanceService.getInstancesByYearAndSemester(year, semester);
    }

    @GetMapping("/{year}/{semester}/{courseId}")
    public ResponseEntity<List<CourseInstance>> getInstancesByCourseIdYearAndSemester(
            @PathVariable int year, @PathVariable int semester, @PathVariable String courseId) {
        List<CourseInstance> instances = courseInstanceService.getInstancesByCourseIdYearAndSemester(courseId, year, semester);
        if (instances.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(instances);
    }

    @DeleteMapping("/{year}/{semester}/{courseId}")
    public ResponseEntity<Void> deleteInstancesByCourseIdYearAndSemester(
            @PathVariable int year, @PathVariable int semester, @PathVariable String courseId) {
        int deletedCount = courseInstanceService.deleteInstancesByCourseIdYearAndSemester(courseId, year, semester);
        if (deletedCount > 0) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // Get all instances
    @GetMapping
    public List<CourseInstance> getAllCourseInstances() {
        return courseInstanceService.getAllInstances();
    }
}
