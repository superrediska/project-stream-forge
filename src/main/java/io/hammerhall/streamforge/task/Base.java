package io.hammerhall.streamforge.task;

import io.hammerhall.streamforge.domain.movie.Actor;
import io.hammerhall.streamforge.domain.movie.Director;
import io.hammerhall.streamforge.domain.movie.DirectorGenre;
import io.hammerhall.streamforge.domain.movie.Genre;
import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.domain.movie.Role;
import io.hammerhall.streamforge.domain.world.City;
import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.domain.world.CountryLanguage;
import io.hammerhall.streamforge.repository.MovieRepository;
import io.hammerhall.streamforge.repository.WorldRepository;
import io.hammerhall.streamforge.service.MovieService;
import io.hammerhall.streamforge.service.MovieServiceImpl;
import io.hammerhall.streamforge.service.WorldService;
import io.hammerhall.streamforge.service.WorldServiceImpl;
import java.util.Collection;

public abstract class Base {

    protected static final MovieService MOVIE_SERVICE = new MovieServiceImpl(new MovieRepository());

    protected static final WorldService WORLD_SERVICE = new WorldServiceImpl(new WorldRepository());

    protected Collection<Movie> movies() {
        return MOVIE_SERVICE.findAllMovies();
    }

    protected Collection<Genre> genres() {
        return MOVIE_SERVICE.findAllGenres();
    }

    protected Collection<Director> directors() {
        return MOVIE_SERVICE.findAllDirectors();
    }

    protected Collection<Actor> actors() {
        return MOVIE_SERVICE.findAllActors();
    }

    protected Collection<Role> roles() {
        return MOVIE_SERVICE.findAllRoles();
    }

    protected Collection<DirectorGenre> directorGenres() {
        return MOVIE_SERVICE.findAllDirectorGenres();
    }

    protected Collection<Country> countries() {
        return WORLD_SERVICE.findAllCountries();
    }

    protected Collection<City> cities() {
        return WORLD_SERVICE.findAllCities();
    }

    protected Collection<CountryLanguage> languages() {
        return WORLD_SERVICE.findAllLanguages();
    }
}
