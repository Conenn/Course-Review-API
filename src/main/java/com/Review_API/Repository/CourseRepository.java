package com.Review_API.Repository;

import com.Review_API.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
    Course findByIdIgnoreCase(String id);
}
