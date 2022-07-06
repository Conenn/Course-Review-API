package com.Review_API.Controller;

import com.Review_API.Model.Course;
import com.Review_API.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController @RequestMapping("/api")
public class CourseController {
    private final CourseService courseService;
    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @RequestMapping("/courses")
    public List<Course> getCourses() {
        return courseService.getCourses();
    }
    @RequestMapping("/courses/{id}")
    public Course getCourse(@PathVariable String id) {
        return courseService.getCourse(id);
    }
}
