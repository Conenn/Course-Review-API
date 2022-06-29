package com.Review_API.Service;

import com.Review_API.ErrorHandling.CourseNotFoundException;
import com.Review_API.Model.Course;
import com.Review_API.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getCourses() {
        return new ArrayList<>(courseRepository.findAll());
    }

    public Course getCourse(String id) {
        Course course = courseRepository.findByIdIgnoreCase(id);
        if (course == null) {
            throw new CourseNotFoundException(id);
        }
        return course;
    }
}
