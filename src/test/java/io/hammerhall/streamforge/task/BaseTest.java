package io.hammerhall.streamforge.task;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.repository.MovieRepository;
import io.hammerhall.streamforge.repository.WorldRepository;
import io.hammerhall.streamforge.service.MovieService;
import io.hammerhall.streamforge.service.MovieServiceImpl;
import io.hammerhall.streamforge.service.WorldService;
import io.hammerhall.streamforge.service.WorldServiceImpl;
import java.util.Collection;
import java.util.List;

public abstract class BaseTest {

    protected static final MovieService MOVIE_SERVICE = new MovieServiceImpl(new MovieRepository());

    protected static final WorldService WORLD_SERVICE = new WorldServiceImpl(new WorldRepository());

    protected Collection<Movie> movies() {
        return MOVIE_SERVICE.findAllMovies();
    }

    protected List<Country> countries() {
        return WORLD_SERVICE.findAllCountries();
    }
}
