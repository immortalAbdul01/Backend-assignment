package com.assignment.assignment.controller;

import com.assignment.assignment.model.CourseInstance;
import com.assignment.assignment.service.CourseInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instances")
public class CourseInstanceController {

    @Autowired
    private CourseInstanceService courseInstanceService;

    @PostMapping
    public CourseInstance createCourseInstance(@RequestBody CourseInstance courseInstance) {
        return courseInstanceService.createCourseInstance(courseInstance);
    }

    @GetMapping("/{year}/{semester}")
    public List<CourseInstance> getInstancesByYearAndSemester(@PathVariable int year, @PathVariable int semester) {
        return courseInstanceService.getInstancesByYearAndSemester(year, semester);
    }

    @GetMapping("/{year}/{semester}/{courseId}")
    public CourseInstance getCourseInstance(@PathVariable int year, @PathVariable int semester, @PathVariable Long courseId) {
        return courseInstanceService.getCourseInstance(courseId).orElse(null);
    }

    @DeleteMapping("/{year}/{semester}/{courseId}")
    public void deleteCourseInstance(@PathVariable int year, @PathVariable int semester, @PathVariable Long courseId) {
        courseInstanceService.deleteCourseInstance(courseId);
    }
}
