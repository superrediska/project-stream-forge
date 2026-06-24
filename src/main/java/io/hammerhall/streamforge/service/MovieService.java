package io.hammerhall.streamforge.service;

import io.hammerhall.streamforge.domain.movie.Movie;
import java.util.Collection;

public interface MovieService {
    Collection<Movie> findAllMovies();
}
