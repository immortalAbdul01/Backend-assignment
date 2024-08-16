package com.assignment.assignment.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Document(collection = "courseInstances")
public class CourseInstance {

    @Id
    private String id;

    @NotBlank(message = "Course ID is required")
    private String courseId;

    @Min(value = 1, message = "Year must be a positive number")
    private int year;

    @Min(value = 1, message = "Semester must be a positive number")
    private int semester;

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}
