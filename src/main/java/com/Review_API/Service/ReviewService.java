package com.Review_API.Service;

import com.Review_API.ErrorHandling.CourseNotFoundException;
import com.Review_API.Model.Course;
import com.Review_API.Model.Review;
import com.Review_API.Repository.CourseRepository;
import com.Review_API.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, CourseRepository courseRepository) {
        this.reviewRepository = reviewRepository;
        this.courseRepository = courseRepository;
    }

    public List<Review> getAllReviews() {
        List<Review> reviews = new ArrayList<>();
        reviewRepository.findAll().forEach(reviews::add);
        return reviews;
    }

    public void addReview(Review review) {
        Course course = courseRepository.findByIdIgnoreCase(review.getCourseId());
        if (course == null) {
            throw new CourseNotFoundException(review.getCourseId());
        }

        //Add date of creation to review
        LocalDate date = LocalDate.now();
        review.setCreatedDate(date);
        reviewRepository.save(review);
    }

    /** Calculate running average for rating and workload for a given course when a review is added. */
    public void calculateAverage(String id) {
        List<Review> reviews = reviewRepository.findByCourseIdIgnoreCase(id);
        Course course = courseRepository.findByIdIgnoreCase(id);

        if (course == null) {
            throw new CourseNotFoundException(id);
        }

        int counter = reviews.size();
        double currentWorkload = 0.0;
        double currentRating = 0.0;
        double currentDifficulty = 0.0;

        for (Review r : reviews) {
            currentWorkload += r.getWorkload();
            currentRating += r.getRating();
            currentDifficulty += r.getDifficulty();
        }

        double avgWorkload = currentWorkload / counter;
        double avgRating = currentRating / counter;
        double avgDifficulty = currentDifficulty / counter;

        course.setAvgWorkload(avgWorkload);
        course.setRating(avgRating);
        course.setDifficulty(avgDifficulty);
        courseRepository.save(course);
    }
    public List<Review> getReviewsById(String id) {
        return reviewRepository.findByCourseIdIgnoreCase(id);
    }
}
