package com.example.springsecurityexample.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(max = 20, min = 1, message = "Error format name")
    private String name;


    @Nationalized
    private String image;

    private Long price;

    @Transient
    public String getPhotosImagePath() {
        if (image == null || id == null) return null;

        return "/book-photos/" + id + "/" + image;
    }
}
