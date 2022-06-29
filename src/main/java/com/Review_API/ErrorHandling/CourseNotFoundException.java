package com.Review_API.ErrorHandling;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(String id) {
        super("Course With ID: " + id + " Not Found");
    }
}
