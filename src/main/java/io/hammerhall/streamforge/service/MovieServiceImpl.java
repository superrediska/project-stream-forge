package io.hammerhall.streamforge.service;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.repository.MovieRepository;
import java.util.Collection;
import java.util.Map;

public class MovieServiceImpl implements MovieService {

    private final Map<Integer, Movie> movies;

    public MovieServiceImpl(MovieRepository movieRepository) {
        movies = movieRepository.getMovies();
    }

    @Override
    public Collection<Movie> findAllMovies() {
        return movies.values();
    }
}
