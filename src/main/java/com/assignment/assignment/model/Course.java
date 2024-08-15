package com.assignment.assignment.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "courses")
public class Course {
    @Id
    private String id;
    private String title;
    private String courseCode;
    private String description;

    // Getters and Setters
}