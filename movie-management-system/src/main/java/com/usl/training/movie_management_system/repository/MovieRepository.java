package com.usl.training.movie_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.usl.training.movie_management_system.entity.Movie;
import java.util.List;


@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
   Movie findByTitle(String title);

   @Query("SELECT DISTINCT m FROM Movie m JOIN m.cast mc JOIN mc.person p WHERE p.actorName = :actorName")
   List<Movie> findAllMoviesByActorName(@Param("actorName") String actorName);
}
