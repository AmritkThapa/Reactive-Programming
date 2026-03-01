package com.amrit.app.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table("movies")
public class Movies {
    @Id
    @Column("movie_id")
    private  int movieId;

    private  String name;

    @Column("movie_desc")
    private  String description;

    private  String producer;

    private  String director;
}
