package com.Review_API.Data;

import com.Review_API.Model.Course;
import com.Review_API.Repository.CourseRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/** Add WGU Computer Science courses to database upon initialization of application. */
@Order(1)
@Component @RequiredArgsConstructor
public class SeedData implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(SeedData.class);
    private final CourseRepository courseRepository;

    // Read in all WGU courses from degree tracker CSV found in WGU discord channel
    public void readFile() throws IOException {
        try (CSVReader coreReader = new CSVReader(new FileReader("src/main/resources/WGU Degree Tracker - Blank.xlsx - Degrees.csv"))) {
            String[] LineInArray;
            int line = 0; // Track current line to skip white lines
            while ((LineInArray = coreReader.readNext()) != null && line < 757) {
                if (line >= 8 && line <= 755) {
                    log.info("Loading " + courseRepository.save(new Course(LineInArray[2], LineInArray[3], 0, 0, 0, "WGU")));
                }
                line++;
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }

//        // Read in all transfer courses from degree tracker found in WGU discord channel
//        try (CSVReader transferReader = new CSVReader(new FileReader("src/main/resources/WGU Degree Tracker - Blank.xlsx - Transfer Data.csv"))) {
//            String[] LineInArray;
//            int line = 0; // Track current line to skip white lines
//            while ((LineInArray = transferReader.readNext()) != null && line < 957) {
//                if (line >= 1 && line <= 955) {
//                    log.info("Loading " + courseRepository.save(new Course(LineInArray[0], LineInArray[1], LineInArray[2], 0, 0, 0, LineInArray[3])));
//                }
//                line++;
//            }
//        } catch (CsvValidationException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public void run(String...args) throws IOException {
        readFile();
    }
}
