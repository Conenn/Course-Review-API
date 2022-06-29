package com.Review_API.Repository;

import com.Review_API.Model.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ReviewRepository extends CrudRepository<Review, Long> {
    List<Review> findByCourseIdIgnoreCase(String id);
}
