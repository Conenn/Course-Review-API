package com.Review_API.Controller;

import com.Review_API.Model.Review;
import com.Review_API.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@Validated
@RestController
@RequestMapping("/api")
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @RequestMapping("/reviews")
    public List<Review> displayAllReviews() {
        return reviewService.getAllReviews();
    }

    @RequestMapping("/reviews/{id}")
    public List<Review> getReviews(@PathVariable String id) {
        return reviewService.getReviewsById(id);
    }

    @PostMapping("/post/reviews")
    void newReview(@Valid @RequestBody Review review) {
        String id = review.getCourseId();
        reviewService.addReview(review);
        reviewService.calculateAverage(id);
    }
}
