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

/**
 * Общий предок задач: даёт доступ к данным курса.
 * <p>
 * Данные грузятся <b>при первом обращении</b>, а не при загрузке класса.
 * Ничего не вызвали — ничего не прочитано.
 */
public abstract class Base {

    /**
     * Держатель данных о фильмах.
     * <p>
     * Вложенный класс здесь — не украшение, а весь смысл правки. JVM
     * инициализирует класс в момент первого активного использования и делает
     * это потокобезопасно, без единой блокировки в нашем коде (JLS 12.4).
     * Пока никто не позвал {@link #movies()} или соседей, {@code MovieHolder}
     * не инициализирован, {@link MovieRepository} не построен и датасет не
     * развёрнут в память.
     * <p>
     * Будь поле объявлено прямо в {@code Base}, оно бы читалось при загрузке
     * {@code Base} — то есть при создании <b>любой</b> задачи, даже про страны,
     * даже если данные ей не нужны вовсе. А это миллионы записей: 388 269
     * фильмов, 817 718 актёров, 3 431 966 ролей.
     */
    private static final class MovieHolder {
        private static final MovieService SERVICE =
                new MovieServiceImpl(new MovieRepository());
    }

    /**
     * Держатель данных о мире — отдельно от фильмов, и это намеренно.
     * <p>
     * Один держатель на двоих означал бы, что задача про страны платит
     * за фильмы, а задача про фильмы — за страны. Раздельные держатели
     * инициализируются независимо: берётся только то, что спросили.
     */
    private static final class WorldHolder {
        private static final WorldService SERVICE =
                new WorldServiceImpl(new WorldRepository());
    }

    protected Collection<Movie> movies() {
        return MovieHolder.SERVICE.findAllMovies();
    }

    protected Collection<Genre> genres() {
        return MovieHolder.SERVICE.findAllGenres();
    }

    protected Collection<Director> directors() {
        return MovieHolder.SERVICE.findAllDirectors();
    }

    protected Collection<Actor> actors() {
        return MovieHolder.SERVICE.findAllActors();
    }

    protected Collection<Role> roles() {
        return MovieHolder.SERVICE.findAllRoles();
    }

    protected Collection<DirectorGenre> directorGenres() {
        return MovieHolder.SERVICE.findAllDirectorGenres();
    }

    protected Collection<Country> countries() {
        return WorldHolder.SERVICE.findAllCountries();
    }

    protected Collection<City> cities() {
        return WorldHolder.SERVICE.findAllCities();
    }

    protected Collection<CountryLanguage> languages() {
        return WorldHolder.SERVICE.findAllLanguages();
    }
}