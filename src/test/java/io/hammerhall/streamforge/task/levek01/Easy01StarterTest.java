package io.hammerhall.streamforge.task.levek01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.task.BaseTest;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Easy Tasks: Starter block")
public class Easy01StarterTest extends BaseTest {

    @Nested
    @DisplayName("ES01. Задание: Получить список всех названий фильмов.")
    class TaskES01 {

        /**
         * Задание: Получить список всех названий фильмов.
         * <p>
         * Описание: необходимо преобразовать коллекцию фильмов в список строк,
         * где каждая строка — это название фильма. Порядок названий в результате
         * соответствует порядку обхода исходной коллекции.
         *
         * @param movies коллекция фильмов
         * @return список названий всех фильмов
         */
        public List<String> task(@NonNull Collection<Movie> movies) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            Collection<Movie> movies = movies();

            List<String> movieTitles = task(movies);

            assertNotNull(movieTitles);
            assertEquals(movies.size(), movieTitles.size());
            assertTrue(movieTitles.stream().allMatch(title -> title != null && !title.isBlank()));

            movieTitles.forEach(System.out::println);
        }
    }

    @Nested
    @DisplayName("ES02. Задание: Найти все фильмы, вышедшие после указанного года.")
    class TaskES02 {

        /**
         * Задание: Найти все фильмы, вышедшие после указанного года.
         * <p>
         * Описание: необходимо сформировать новую коллекцию фильмов и оставить только те,
         * год выхода которых строго больше указанного года.
         *
         * @param movies     коллекция фильмов
         * @param targetYear год, после которого нужно найти фильмы
         * @return список фильмов, вышедших после указанного года
         */
        public List<Movie> task(@NonNull Collection<Movie> movies, int targetYear) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            Collection<Movie> movies = movies();

            int targetYear = 2000;

            List<Movie> moviesAfterYear = task(movies, targetYear);

            assertNotNull(moviesAfterYear);
            assertFalse(moviesAfterYear.isEmpty());
            assertTrue(movies.containsAll(moviesAfterYear));

            moviesAfterYear.forEach(System.out::println);
        }
    }

    @Nested
    @DisplayName("ES03. Задание: Получить первые N фильмов из базы.")
    class TaskES03 {

        /**
         * Задание: Получить первые N фильмов из базы.
         * <p>
         * Описание: необходимо получить первые N фильмов из исходной коллекции в порядке
         * её обхода. Если в коллекции меньше фильмов, чем указано в параметре limit,
         * необходимо вернуть все доступные фильмы.
         *
         * @param movies коллекция фильмов
         * @param limit  количество фильмов, которое нужно получить; если значение
         *               отрицательное, будет использовано 0
         * @return список из первых N фильмов исходной коллекции или всех фильмов,
         * если limit больше размера коллекции
         */
        public List<Movie> task(@NonNull Collection<Movie> movies, int limit) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            Collection<Movie> movies = movies();

            int limit = 5;

            List<Movie> firstMovies = task(movies, limit);

            assertNotNull(firstMovies);
            assertEquals(Math.min(limit, movies.size()), firstMovies.size());
            assertTrue(task(movies, -1).isEmpty());
            assertEquals(movies.size(), task(movies, movies.size() + 100).size());

            firstMovies.forEach(System.out::println);
        }
    }
}
