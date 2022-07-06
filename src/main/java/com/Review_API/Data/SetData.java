package com.Review_API.Data;

import com.Review_API.Model.AppUser;
import com.Review_API.Model.Role;
import com.Review_API.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


@Order(2)
@Component @Slf4j
public class SetData implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory.getLogger(SetData.class);
    private final UserService userService;

    @Autowired
    public SetData(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
    }
}

//    public void calculateAverages() {
//        List<Course> courses = courseRepository.findAll();
//
//        for (Course course : courses) {
//            List<Review> courseReviews = reviewRepository.findByCourseIdIgnoreCase(course.getId());
//            if (courseReviews.size() == 0)
//                continue;
//
//            double currentWorkload = 0.0;
//            double currentDifficulty = 0.0;
//
//            for (Review review : courseReviews) {
//                currentWorkload = review.getWorkload();
//                currentDifficulty = review.getDifficulty();
//            }
//
//            double avgWorkload = currentWorkload / courseReviews.size();
//            double avgDifficulty = currentDifficulty / courseReviews.size();
//
//            course.setAvgWorkload(avgWorkload);
//            course.setDifficulty(avgDifficulty);
//            courseRepository.save(course);
//        }
//    }
//}

