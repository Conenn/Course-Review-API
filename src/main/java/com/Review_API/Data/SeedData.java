package com.Review_API.Data;

import com.Review_API.ErrorHandling.CourseNotFoundException;
import com.Review_API.Model.Course;
import com.Review_API.Model.Review;
import com.Review_API.Repository.CourseRepository;
import com.Review_API.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/** Add WGU Computer Science courses to database upon initialization of application. */
@Order(1)
@Component
public class SeedData implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(SeedData.class);

    private final CourseRepository courseRepository;

    @Autowired
    public SeedData(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String...args) {
        log.info("Loading " + courseRepository.save(new Course("C482", "Software 1", 0, 0, "CORE")));
        log.info("Loading " + courseRepository.save(new Course("C195", "Software 2", 0, 0, "CORE")));
        log.info("Loading " + courseRepository.save(new Course("C959", "Discrete Mathematics 1", 0, 0,  "GenEd")));
        log.info("Loading " + courseRepository.save(new Course("C960", "Discrete Mathematics 2", 0, 0, "GenEd")));
        log.info("Loading " + courseRepository.save(new Course("C175", "Data Management - Foundations", 0, 0, "CORE")));
        log.info("Loading " + courseRepository.save(new Course("C170", "Data Management - Applications", 0, 0, "CORE")));
        log.info("Loading " + courseRepository.save(new Course("D191", "Advanced Data Management", 0, 0, "CORE")));
        log.info("Loading " + courseRepository.save(new Course("C173", "Scripting and Programming - Foundations", 0, 0, "CORE")));
        log.info("Loading " + courseRepository.save(new Course("C867", "Scripting and Programming - Applications", 0, 0, "CORE")));
        log.info("Loading " + courseRepository.save(new Course("C955", "Applied Probability and Statistics", 0, 0, "GenED")));
        log.info("Loading " + courseRepository.save(new Course("C958", "Calculus 1", 0, 0, "GenED")));
        log.info("Loading " + courseRepository.save(new Course("C951", "Introduction to Artificial Intelligence", 0, 0, "CORE")));
        log.info("Loading " + courseRepository.save(new Course("C964", "Computer Science Capstone", 0, 0, "CORE")));
        log.info("Loading " + courseRepository.save(new Course("C172", "Network and Security - Foundations", 0, 0, "CORE")));
        log.info("Loading " + courseRepository.save(new Course("C836", "Fundamentals of Information Security", 0, 0, "CORE")));
        log.info("Loading " + courseRepository.save(new Course("C182", "Introduction to IT", 0, 0, "CORE")));
        log.info("Loading " + courseRepository.save(new Course("C779", "Web Development - Foundations", 0, 0, "CORE")));
        log.info("Loading " + courseRepository.save(new Course("C952", "Computer Architecture", 0, 0, "CORE")));
        log.info("Loading " + courseRepository.save(new Course("C949", "Data Structures and Algorithms I", 0, 0, "CORE")));
        log.info("Loading " + courseRepository.save(new Course("C950", "Data Structures and Algorithms II", 0, 0, "CORE")));
        log.info("Loading " + courseRepository.save(new Course("C191", "Operating Systems for Programmers", 0, 0, "CORE")));
        log.info("Loading " + courseRepository.save(new Course("C961", "Ethics in Technology", 0, 0, "CORE")));
        log.info("Loading " + courseRepository.save(new Course("C188", "Software Engineering", 0, 0, "CORE")));
        log.info("Loading " + courseRepository.save(new Course("C846", "Business of IT - Applications", 0, 0, "CORE")));
        log.info("Loading " + courseRepository.save(new Course("D194", "IT Leadership Foundations", 0, 0, "CORE")));
        log.info("Loading " + courseRepository.save(new Course("C165", "Integrated Physical Sciences", 0, 0, "GenED")));
        log.info("Loading " + courseRepository.save(new Course("C683", "Natural Science Lab", 0, 0, "GenED")));
        log.info("Loading " + courseRepository.save(new Course("C768", "Technical Communication", 0, 0, "CORE")));
        log.info("Loading " + courseRepository.save(new Course("C857", "Software Quality Assurance", 0, 0, "CORE")));
        log.info("Loading " + courseRepository.save(new Course("C176", "Business of IT - Project Management", 0, 0, "CORE")));
        log.info("Loading " + courseRepository.save(new Course("C455", "English Composition I", 0, 0, "GenED")));
        log.info("Loading " + courseRepository.save(new Course("C963", "American Politics and the US Constitution", 0, 0, "GenED")));
        log.info("Loading " + courseRepository.save(new Course("C255", "Introduction to Geography", 0, 0, "GenED")));
        log.info("Loading " + courseRepository.save(new Course("C464", "Introduction to Communication", 0, 0, "GenED")));
        log.info("Loading " + courseRepository.save(new Course("C100", "Introduction to Humanities", 0, 0, "GenED")));
    }
}
