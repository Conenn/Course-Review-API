package com.Review_API.Data;

import com.Review_API.Model.Course;
import com.Review_API.Model.Review;
import com.Review_API.Repository.CourseRepository;
import com.Review_API.Repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Order(2)
@Component @RequiredArgsConstructor
public class SetAverages implements CommandLineRunner {

    private final CourseRepository courseRepository;
    private final ReviewRepository reviewRepository;


    public void setCourseAverages() {
        HashMap<String, List<Double>> courseMap = new HashMap<>();

        List<Review> reviews = new ArrayList<>();
        reviewRepository.findAll().forEach(reviews::add);

        for (Review review : reviews) {
          String courseId = review.getCourseId();

          List<Double> metrics = new ArrayList<>();
          metrics.add(review.getRating());
          metrics.add(review.getDifficulty());
          metrics.add(review.getWorkload());
          metrics.add(1.0);

          if (courseMap.containsKey(courseId)) {
              List<Double> courseList = courseMap.get(courseId);
              courseList.set(0, courseList.get(0) + metrics.get(0));
              courseList.set(1, courseList.get(1) + metrics.get(1));
              courseList.set(2, courseList.get(2) + metrics.get(2));
              courseList.set(3, courseList.get(3) + 1);
          }
          else {
              courseMap.put(courseId, metrics);
          }
        }

        for (Map.Entry<String,List<Double>> entry : courseMap.entrySet()) {
            Double entryLength = entry.getValue().get(3);
            double avgRating = entry.getValue().get(0)/ entryLength;
            double avgDifficulty = entry.getValue().get(1)/ entryLength;
            double avgWorkload = entry.getValue().get(2)/ entryLength;

            Course course = courseRepository.findByIdIgnoreCase(entry.getKey());
            course.setAvgWorkload(avgWorkload);
            course.setRating(avgRating);
            course.setDifficulty(avgDifficulty);
            courseRepository.save(course);
        }
    }


    @Override
    public void run(String... args) throws Exception {
        setCourseAverages();
    }
}
