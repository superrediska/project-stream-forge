package io.hammerhall.streamforge.task.levek02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.BaseTest;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Medium01StarterTest extends BaseTest {

    @Nested
    @DisplayName("MS01. Задание: Сгруппировать фильмы по количеству жанров.")
    class TaskMS01 {

        /**
         * Задание: Сгруппировать фильмы по количеству жанров.
         * <p>
         * Описание: необходимо сгруппировать фильмы по количеству жанров, указанных
         * у каждого фильма. Ключом итоговой Map является количество жанров, а значением
         * — список фильмов, у которых ровно такое количество жанров.
         *
         * @param movies коллекция фильмов
         * @return Map, где ключ — количество жанров, значение — список фильмов
         * с таким количеством жанров
         */
        public Map<Integer, List<Movie>> task(@NonNull Collection<Movie> movies) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            Collection<Movie> movies = movies();

            Map<Integer, List<Movie>> moviesByGenreCount = task(movies);

            assertNotNull(moviesByGenreCount);
            assertFalse(moviesByGenreCount.isEmpty());
            assertTrue(moviesByGenreCount.containsKey(1));

            moviesByGenreCount.forEach((genreCount, moviesWithSameGenreCount) ->
                    System.out.println(genreCount + " " + moviesWithSameGenreCount));
        }
    }

    @Nested
    @DisplayName("MS02. Задание: Посчитать количество фильмов для каждого года.")
    class TaskMS02 {

        /**
         * Задание: Посчитать количество фильмов для каждого года.
         * <p>
         * Описание: необходимо сгруппировать фильмы по году выхода и посчитать,
         * сколько фильмов вышло в каждом году. Ключом итоговой Map является год
         * выхода фильма, а значением — количество фильмов, вышедших в этот год.
         *
         * @param movies коллекция фильмов
         * @return Map, где ключ — год выхода, значение — количество фильмов за этот год
         */
        public Map<Integer, Long> task(@NonNull Collection<Movie> movies) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            Collection<Movie> movies = movies();

            Map<Integer, Long> movieCountByYear = task(movies);

            assertNotNull(movieCountByYear);
            assertFalse(movieCountByYear.isEmpty());
            assertTrue(movieCountByYear.keySet().stream()
                    .allMatch(year -> year != null && year > 0));

            assertTrue(movieCountByYear.values().stream()
                    .allMatch(count -> count != null && count > 0));

            movieCountByYear.forEach((year, movieCount) -> System.out.println(year + " " + movieCount));
        }
    }

    @Nested
    @DisplayName("MS03. Задание: Отсортировать страны по количеству городов в порядке убывания.")
    class TaskMS03 {

        /**
         * Задание: Отсортировать страны по количеству городов в порядке убывания.
         * <p>
         * Описание: необходимо отсортировать список стран в порядке убывания
         * количества городов, принадлежащих каждой стране.
         * <p>
         * Страны с одинаковым количеством городов могут располагаться
         * в любом порядке.
         *
         * @param countries список стран
         * @return новый список стран, отсортированный по количеству городов
         * в порядке убывания
         */
        public List<Country> task(@NonNull List<Country> countries) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {

            List<Country> countries = countries();

            List<Country> sorted = task(countries);

            assertNotNull(sorted);
            assertFalse(sorted.isEmpty());

            assertEquals(countries.size(), sorted.size());

            IntStream.range(1, sorted.size())
                    .forEach(i -> assertTrue(
                            sorted.get(i - 1).getCities().size()
                                    >= sorted.get(i).getCities().size()));

            assertTrue(task(List.of()).isEmpty());

            System.out.println("Страны по количеству городов:");
            sorted.forEach(country ->
                    System.out.println(country.getName()
                            + " -> " + country.getCities().size()));
        }
    }

    @Nested
    @DisplayName("MS04. Задание: Собрать список примечательных фильмов.")
    class TaskMS04 {
        /**
         * Задание: Собрать список примечательных фильмов.
         * <p>
         * Описание: по переданной коллекции фильмов необходимо собрать список,
         * включающий:
         * 1. самый ранний по году выхода фильм;
         * 2. самый поздний по году выхода фильм;
         * 3. фильм с наибольшим числом жанров.
         * <p>
         * Если какой-либо из фильмов определить невозможно (например, коллекция пуста),
         * он в результат не добавляется. Повторяющиеся фильмы в результате не дублируются.
         * Для пустой коллекции возвращается пустой список.
         *
         * @param movies коллекция фильмов
         * @return список примечательных фильмов без повторов; пустой список, если их нет
         */
        public List<Movie> task(@NonNull Collection<Movie> movies) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            Collection<Movie> movies = movies();

            List<Movie> result = task(movies);

            assertNotNull(result);
            assertFalse(result.isEmpty());
            assertEquals(result.size(), result.stream().distinct().count());

            int minYear = movies.stream().mapToInt(Movie::getYear).min().orElseThrow();
            int maxYear = movies.stream().mapToInt(Movie::getYear).max().orElseThrow();
            assertTrue(result.stream().anyMatch(movie -> movie.getYear() == minYear));
            assertTrue(result.stream().anyMatch(movie -> movie.getYear() == maxYear));

            assertTrue(task(List.of()).isEmpty());

            result.forEach(System.out::println);
        }
    }
}
