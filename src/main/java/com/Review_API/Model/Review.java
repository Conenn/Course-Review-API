package com.Review_API.Model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Data
@Table
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty(message = "Course Must Be Selected")
    @NotNull(message = "Course Must Be Selected")
    private String courseId;

    @Column(columnDefinition="COLUMN_TYPE default '0'")
    @DecimalMax(value = "5", message = "Difficulty Can't Be Greater Than 5")
    @DecimalMin(value = "1", message = "Difficulty Can't Be Less Than 1")
    private double difficulty;

    @DecimalMax(value = "5", message = "Rating Can't Be Greater Than 5")
    @DecimalMin(value = "1", message = "Rating Can't Be Less Than 1")
    private double rating;

    @DecimalMax(value = "60", message = "Workload Can't Be Greater than 60")
    @DecimalMin(value = "1", message = "Workload Can't Be Less Than 0")
    private double workload;

    @NotEmpty(message = "Comment Required")
    @Size(max = 2500)
    private String comment;

    private LocalDate createdDate;

    public Review(String comment, String courseId, double difficulty, double rating, double workload){
        this.comment = comment;
        this.courseId = courseId;
        this.rating = rating;
        this.difficulty = difficulty;
        this.workload = workload;
    }

    public Review() {
    }
}
