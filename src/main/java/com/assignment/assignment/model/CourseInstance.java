// CourseInstance.java
package com.assignment.assignment.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "courseInstances")
public class CourseInstance {
    @Id
    private String id;
    private String courseId;
    private int year;
    private int semester;

    // Getters and Setters
}