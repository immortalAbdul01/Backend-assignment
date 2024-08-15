// CourseInstanceController.java
package com.assignment.assignment.controller;

import com.assignment.assignment.model.CourseInstance;
import com.assignment.assignment.service.CourseInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{year}/{semester}/{id}")
    public ResponseEntity<CourseInstance> getInstanceById(@PathVariable int year, @PathVariable int semester, @PathVariable String id) {
        Optional<CourseInstance> courseInstance = courseInstanceService.getInstanceById(id);
        return courseInstance.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{year}/{semester}/{id}")
    public ResponseEntity<Void> deleteCourseInstance(@PathVariable int year, @PathVariable int semester, @PathVariable String id) {
        courseInstanceService.deleteCourseInstance(id);
        return ResponseEntity.noContent().build();
    }
}