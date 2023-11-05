package com.wl.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long movieId;

    @Column(name = "movie_name")
    private String movieName;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(
            name = "movie_actor",
            joinColumns = {@JoinColumn()}
    )
    private Set<Actor> actors = new HashSet<>();

    public Movie() {

    }

    public Movie(String movieName) {
        this.movieName = movieName;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }
}
