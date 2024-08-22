package com.usl.training.movie_management_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movie")
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Integer movieId;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "budget", nullable = false)
    private Long budget;
    @Column(name = "homepage", nullable = false)
    private String homepage;
    @Column(name = "overview", length = 2000, nullable = false)
    private String overview;
    @Column(name = "popularity", nullable = false)
    private Double popularity;
    @Column(name = "release_date", nullable = false)
    private Date releaseDate;
    @Column(name = "revenue", nullable = false)
    private Long revenue;
    @Column(name = "runtime", nullable = false)
    private Integer runtime;
    @Column(name = "movie_status", nullable = false)
    private String movieStatus;
    @Column(name = "tagline", nullable = false)
    private String tagline;
    @Column(name = "vote_average", nullable = false)
    private Double votesAvg;
    @Column(name = "vote_count", nullable = false)
    private Long votesCount;
    @OneToMany(mappedBy = "movie")
    private List<MovieCast> cast;
//    @ManyToMany
//    @JoinTable(
//            name = "movie_genres",
//            joinColumns = @JoinColumn(name = "movie_id"),
//            inverseJoinColumns = @JoinColumn(name = "genre_id")
//    )
//    private List<Genre> genres;
//    @ManyToMany
//    @JoinTable(
//            name = "production_country",
//            joinColumns = @JoinColumn(name = "movie_id"),
//            inverseJoinColumns = @JoinColumn(name = "country_id")
//    )
//    private List<Country> countries;
//    @ManyToMany
//    @JoinTable(
//            name = "movie_languages",
//            joinColumns = @JoinColumn(name = "movie_id"),
//            inverseJoinColumns = @JoinColumn(name = "language_id")
//    )
//    private List<Language> languages;




}
