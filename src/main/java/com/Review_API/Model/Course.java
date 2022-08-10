package com.Review_API.Model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.util.List;

@Table
@Data
@Entity
public class Course {
    @Id
    @GeneratedValue
    private Long db_id;

    private String id;

    private String name;

    @Digits(integer=2, fraction=2)
    private double avgWorkload;

    @Digits(integer=1, fraction=2)
    private double rating;
    @Digits(integer=2, fraction=2 )
    private double difficulty;
    private String type;
    private String external_name;

    public Course(String id, String name, double rating, double difficulty, double avgWorkload, String type) {
        super();
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.avgWorkload = avgWorkload;
        this.difficulty = difficulty;
        this.type = type;
    }

    public Course(String id, String name, String external_name, double rating, double difficulty, double avgWorkload, String type) {
        super();
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.avgWorkload = avgWorkload;
        this.difficulty = difficulty;
        this.type = type;
        this.external_name = external_name;
    }

    public Course() {
    }
}
