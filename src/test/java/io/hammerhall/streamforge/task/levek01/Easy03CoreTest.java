package io.hammerhall.streamforge.task.levek01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.domain.world.City;
import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.BaseTest;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;
import lombok.NonNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Easy Tasks: Core block")
class Easy03CoreTest extends BaseTest {

    @Nested
    @DisplayName("EC01. Задание: Получить последние N уникальных имён режиссёров, отсортированных по алфавиту.")
    class TaskEC01 {

        /**
         * Задание: Получить последние N уникальных имён режиссёров в алфавитном порядке.
         * <p>
         * Описание: из всех фильмов извлекаются имена всех режиссёров.
         * Результатом является список не более чем из N уникальных имён,
         * отсортированных по алфавиту. Если список уникальных имён содержит
         * больше N элементов, в результат попадают только последние N позиций
         * отсортированного списка (элементы с конца). Если список уникальных
         * имён содержит N или менее элементов, результат содержит все уникальные
         * имена. Отрицательное значение limit трактуется как 0 и даёт пустой список.
         * <p>
         * Например, уникальные имена после сортировки: A, B, C, D, E; limit = 2.
         * Результат: D, E.
         *
         * @param movies коллекция фильмов
         * @param limit  максимальное количество возвращаемых имён;
         *               отрицательное значение даёт пустой результат
         * @return список последних N уникальных имён режиссёров в алфавитном порядке
         */
        public List<String> task(@NonNull Collection<Movie> movies, int limit) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            Collection<Movie> movies = movies();

            int limit = 10;

            List<String> lastUniqueDirectorNames = task(movies, limit);

            assertNotNull(lastUniqueDirectorNames);
            assertFalse(lastUniqueDirectorNames.isEmpty());
            assertTrue(lastUniqueDirectorNames.size() <= limit);
            assertTrue(lastUniqueDirectorNames.stream()
                    .allMatch(name -> name != null && !name.isBlank()));

            IntStream.range(1, lastUniqueDirectorNames.size())
                    .mapToObj(i -> lastUniqueDirectorNames.get(i - 1).compareTo(lastUniqueDirectorNames.get(i)) <= 0)
                    .forEach(Assertions::assertTrue);

            assertTrue(task(movies, -1).isEmpty());

            lastUniqueDirectorNames.forEach(System.out::println);
        }
    }

    @Nested
    @DisplayName("EC02. Задание: Вычислить суммарную численность населения всех городов мира.")
    class TaskEC02 {

        /**
         * Задание: Вычислить суммарную численность населения всех городов мира.
         * <p>
         * Описание: результатом является сумма значений численности населения
         * всех городов из всех стран мира.
         *
         * @param countries список стран мира
         * @return суммарная численность населения всех городов мира;
         *         для пустого списка стран — 0
         */
        public long task(@NonNull List<Country> countries) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            List<Country> countries = countries();

            long totalCityPopulation = task(countries);

            assertTrue(totalCityPopulation > 0,
                    "Суммарное население городов должно быть положительным");

            assertEquals(0L, task(List.of()));

            System.out.println("Суммарное население всех городов: " + totalCityPopulation);
        }
    }

    @Nested
    @DisplayName("EC03. Получить список названий столиц всех стран.")
    class TaskEC03 {

        /**
         * Задание: Получить список названий столиц всех стран.
         * <p>
         * Описание: для каждой страны необходимо среди её городов найти столицу
         * и получить её название. Страны, у которых столица не найдена, пропускаются.
         *
         * @param countries список стран мира
         * @return список названий столиц
         */
        public List<String> task(@NonNull List<Country> countries) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            List<Country> countries = countries();

            List<String> capitalNames = task(countries);

            assertNotNull(capitalNames);
            assertFalse(capitalNames.isEmpty());

            assertTrue(capitalNames.size() <= countries.size());

            assertTrue(capitalNames.stream()
                    .allMatch(name -> name != null && !name.isBlank()));

            assertTrue(task(List.of()).isEmpty());

            System.out.println("Найдено столиц: " + capitalNames.size());
            capitalNames.forEach(System.out::println);
        }
    }

    @Nested
    @DisplayName("EC04. Задание: Получить список стран, отсортированный сначала по континенту, затем по названию.")
    class TaskEC04 {

        /**
         * Задание: Получить список стран, отсортированный сначала по континенту, затем по названию.
         * <p>
         * Описание: необходимо отсортировать страны в порядке возрастания:
         * сначала по названию континента (лексикографически), а среди стран
         * одного континента — по названию страны (лексикографически).
         *
         * @param countries список стран мира
         * @return список стран, отсортированный по континенту и названию
         */
        public List<Country> task(@NonNull List<Country> countries) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            List<Country> countries = countries();

            List<Country> sortedCountries = task(countries);

            assertNotNull(sortedCountries);
            assertFalse(sortedCountries.isEmpty());
            assertEquals(countries.size(), sortedCountries.size());
            assertTrue(sortedCountries.containsAll(countries));

            assertTrue(task(List.of()).isEmpty());

            sortedCountries
                    .forEach(country -> System.out.printf("%s — %s%n", country.getContinent(), country.getName()));
        }
    }

    @Nested
    @DisplayName("EC05. Задание: Найти столицу с наибольшей численностью населения.")
    class TaskEC05 {

        /**
         * Задание: Найти столицу с наибольшей численностью населения.
         * <p>
         * Описание: для каждой страны необходимо определить её столицу — город
         * с идентификатором, равным {@code country.getCapital()}. Среди всех
         * найденных столиц нужно найти город с максимальной численностью населения.
         * Если ни одна столица не найдена, выбрасывается {@link NoSuchElementException}.
         *
         * @param countries список стран мира
         * @return столица с наибольшей численностью населения
         * @throws NoSuchElementException если список стран пуст или ни у одной
         *                                страны не найдена столица
         */
        public City task(List<Country> countries) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            List<Country> countries = countries();

            City capitalWithMaxPopulation = task(countries);

            assertNotNull(capitalWithMaxPopulation);
            assertNotNull(capitalWithMaxPopulation.getName());
            assertFalse(capitalWithMaxPopulation.getName().isBlank());
            assertTrue(capitalWithMaxPopulation.getPopulation() > 0);

            assertThrows(NoSuchElementException.class, () -> task(List.of()));

            System.out.printf("Столица с наибольшим населением: %s — %d%n",
                    capitalWithMaxPopulation.getName(), capitalWithMaxPopulation.getPopulation());
        }
    }

    @Nested
    @DisplayName("EC06. Задание: Найти все фильмы, у которых больше одного жанра.")
    class TaskEC06 {

        /**
         * Задание: Найти все фильмы, у которых больше одного жанра.
         * <p>
         * Описание: необходимо отфильтровать коллекцию фильмов и оставить только те фильмы,
         * у которых количество жанров строго больше одного.
         *
         * @param movies коллекция фильмов
         * @return список фильмов, у которых строго больше одного жанра
         */
        public List<Movie> task(@NonNull Collection<Movie> movies) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            Collection<Movie> movies = movies();

            List<Movie> moviesWithMultipleGenres = task(movies);

            assertNotNull(moviesWithMultipleGenres);
            assertFalse(moviesWithMultipleGenres.isEmpty());
            assertTrue(moviesWithMultipleGenres.size() <= movies.size());
            assertTrue(movies.containsAll(moviesWithMultipleGenres));

            moviesWithMultipleGenres.forEach(System.out::println);
        }
    }

    @Nested
    @DisplayName("EC07. Задание: Найти все фильмы, у которых больше одного режиссёра.")
    class TaskEC07 {

        /**
         * Задание: Найти все фильмы, у которых больше одного режиссёра.
         * <p>
         * Описание: необходимо отфильтровать коллекцию фильмов и оставить только те фильмы,
         * у которых количество режиссёров строго больше одного.
         *
         * @param movies коллекция фильмов
         * @return список фильмов, у которых строго больше одного режиссёра
         */
        public List<Movie> task(@NonNull Collection<Movie> movies) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            Collection<Movie> movies = movies();

            List<Movie> moviesWithMultipleDirectors = task(movies);

            assertNotNull(moviesWithMultipleDirectors);
            assertFalse(moviesWithMultipleDirectors.isEmpty());
            assertTrue(moviesWithMultipleDirectors.size() <= movies.size());
            assertTrue(movies.containsAll(moviesWithMultipleDirectors));

            moviesWithMultipleDirectors.forEach(System.out::println);
        }
    }

    @Nested
    @DisplayName("EC08. Задание: Построить индекс стран по коду.")
    class TaskEC08 {

        /**
         * Задание: Построить индекс стран по коду.
         * <p>
         * Описание: необходимо преобразовать коллекцию стран в ассоциативный массив,
         * в котором ключом выступает код страны, а значением — её название.
         * Такой индекс позволяет получать название страны напрямую по её коду.
         * <p>
         * Коды стран в исходных данных уникальны. Если коллекция пуста,
         * необходимо вернуть пустой ассоциативный массив.
         *
         * @param countries коллекция стран
         * @return ассоциативный массив, сопоставляющий коду страны её название
         */
        public Map<String, String> task(@NonNull Collection<Country> countries) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            Collection<Country> countries = countries();

            Map<String, String> index = task(countries);

            assertNotNull(index);
            assertFalse(index.isEmpty());
            assertEquals(countries.size(), index.size());

            Country any = countries.iterator().next();
            assertEquals(any.getName(), index.get(any.getCode()));

            assertTrue(task(List.of()).isEmpty());

            index.forEach((code, name) -> System.out.println(code + " -> " + name));
        }
    }
}