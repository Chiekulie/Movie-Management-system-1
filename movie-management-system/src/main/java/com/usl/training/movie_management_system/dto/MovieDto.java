package com.usl.training.movie_management_system.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    @Column(name = "movie_id")
    private Integer movieId;
    @Column(name = "title")
    private String title;
    @Column(name = "budget")
    private Long budget;
    @Column(name = "homepage")
    private String homepage;
    @Column(name = "overview")
    private String overview;
    @Column(name = "popularity")
    private Double popularity;
    @Column(name = "release_date")
    private Date releaseDate;
    @Column(name = "revenue")
    private Long revenue;
    @Column(name = "runtime")
    private Integer runtime;
    @Column(name = "movie_status")
    private String movieStatus;
    @Column(name = "tagline")
    private String tagline;
    @Column(name = "vote_average")
    private Double votesAvg;
    @Column(name = "vote_count")
    private Long votesCount;
}
