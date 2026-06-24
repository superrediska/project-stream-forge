package io.hammerhall.streamforge.task.levek02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.BaseTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Medium Tasks: Basic block")
class Medium02BasicTest extends BaseTest {

    @Nested
    @DisplayName("MB01. Задание: Сгруппировать фильмы по десятилетиям.")
    class TaskMB01 {

        /**
         * Задание: Сгруппировать фильмы по десятилетиям.
         * <p>
         * Описание: необходимо сгруппировать фильмы по десятилетиям их выхода. Десятилетие
         * вычисляется как год, округлённый вниз до десятков: например, 1994 относится
         * к 1990-м, 2001 — к 2000-м, 2019 — к 2010-м. Для каждого десятилетия нужно собрать
         * список фильмов, вышедших в этом десятилетии.
         * <p>
         * Итоговая структура должна быть отсортирована по десятилетию в порядке возрастания.
         *
         * @param movies коллекция фильмов
         * @return {@code TreeMap}, где ключ — десятилетие, а значение — список фильмов,
         * вышедших в этом десятилетии
         */
        public TreeMap<Integer, List<Movie>> task(@NonNull Collection<Movie> movies) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            Collection<Movie> movies = movies();

            TreeMap<Integer, List<Movie>> moviesByDecade = task(movies);

            assertNotNull(moviesByDecade);
            assertFalse(moviesByDecade.isEmpty());

            assertNotNull(task(List.of()));
            assertTrue(task(List.of()).isEmpty());

            moviesByDecade.forEach((decade, decadeMovies) -> {
                assertNotNull(decade);
                assertTrue(decade > 0);
                assertEquals(0, decade % 10);

                assertNotNull(decadeMovies);
                assertFalse(decadeMovies.isEmpty());

                decadeMovies.forEach(movie -> {
                    assertNotNull(movie);
                    assertTrue(movie.getYear() >= decade);
                    assertTrue(movie.getYear() <= decade + 9);
                });
            });

            assertEquals(moviesByDecade.keySet().stream().sorted().toList(), new ArrayList<>(moviesByDecade.keySet()));

            moviesByDecade.forEach((decade, decadeMovies) ->
                    System.out.printf("Десятилетие: %d | Количество фильмов: %d%n", decade, decadeMovies.size()));
        }
    }

    @Nested
    @DisplayName("MB02. Задание: Сгруппировать фильмы по году и перечислить их названия.")
    class TaskMB02 {

        /**
         * Задание: Сгруппировать фильмы по году и перечислить их названия.
         * <p>
         * Описание: необходимо сгруппировать фильмы по году выхода и для каждого года
         * получить список названий фильмов, вышедших в этот год. Итоговая Map должна
         * быть отсортирована по году в порядке возрастания.
         *
         * @param movies коллекция фильмов
         * @return TreeMap, где ключ — год выхода, значение — список названий фильмов
         * за этот год
         */
        public TreeMap<Integer, List<String>> task(@NonNull Collection<Movie> movies) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            Collection<Movie> movies = movies();

            TreeMap<Integer, List<String>> movieTitlesByYear = task(movies);

            assertNotNull(movieTitlesByYear);
            assertFalse(movieTitlesByYear.isEmpty());
            assertInstanceOf(TreeMap.class, movieTitlesByYear);
            assertTrue(movieTitlesByYear.keySet().stream()
                    .allMatch(year -> year != null && year > 0));

            assertTrue(movieTitlesByYear.values().stream()
                    .flatMap(Collection::stream)
                    .allMatch(title -> title != null && !title.isBlank()));

            movieTitlesByYear.forEach((year, movieTitles) ->
                    System.out.println(year + " : " + movieTitles));
        }
    }

    @Nested
    @DisplayName("MB03. Задание: Отсортировать страны по плотности населения в порядке убывания.")
    class TaskMB03 {

        /**
         * Задание: Отсортировать страны по плотности населения в порядке убывания.
         * <p>
         * Описание: плотность населения страны вычисляется как отношение численности
         * населения к площади. Необходимо отсортировать страны по убыванию плотности.
         * Страны, для которых плотность посчитать нельзя или она равна нулю,
         * в результат не включаются.
         * <p>
         * Страны с одинаковой плотностью могут располагаться в любом порядке.
         *
         * @param countries список стран
         * @return новый список стран, отсортированный по плотности населения
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
            assertTrue(sorted.stream().allMatch(c -> c.getPopulation() > 0));

            IntStream.range(1, sorted.size()).forEach(i -> {
                double prev = (double) sorted.get(i - 1).getPopulation() / sorted.get(i - 1).getSurfaceArea();
                double curr = (double) sorted.get(i).getPopulation() / sorted.get(i).getSurfaceArea();
                assertTrue(prev >= curr);
            });

            assertTrue(task(List.of()).isEmpty());
            sorted.forEach(c -> System.out.println(c.getName() + " -> "
                    + (double) c.getPopulation() / c.getSurfaceArea()));
        }
    }

    @Nested
    @DisplayName("MB04. Задание: Найти минимальное, максимальное и среднее население стран мира.")
    class TaskMB04 {

        /**
         * Задание: Найти минимальное, максимальное и среднее население среди стран мира.
         * <p>
         * Описание: по коллекции стран необходимо вычислить сводную статистику
         * численности населения — минимальное, максимальное и среднее значение
         * среди всех стран. Для пустой коллекции статистика не содержит элементов.
         *
         * @param countries коллекция стран
         * @return сводная статистика населения: минимум, максимум, среднее, сумма и количество
         */
        public LongSummaryStatistics task(@NonNull Collection<Country> countries) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            List<Country> countries = countries();
            LongSummaryStatistics stats = task(countries);

            assertNotNull(stats);
            assertEquals(countries.size(), stats.getCount());
            assertTrue(stats.getMin() <= stats.getMax());
            assertTrue(stats.getAverage() >= stats.getMin());
            assertTrue(stats.getAverage() <= stats.getMax());

            assertEquals(0, task(List.of()).getCount());

            System.out.printf("min=%d max=%d avg=%.2f%n", stats.getMin(), stats.getMax(), stats.getAverage());
        }
    }

    @Nested
    @DisplayName("MB05. Задание: Посчитать количество встреч каждого жанра.")
    class TaskMB05 {

        /**
         * Задание: Посчитать количество встреч каждого жанра.
         * <p>
         * Описание: необходимо пройти по всем фильмам, получить все их жанры и
         * посчитать, сколько раз каждое название жанра встречается в жанровых списках
         * фильмов. Ключом итоговой Map является название жанра, а значением — количество
         * встреч этого жанра среди всех фильмов.
         *
         * @param movies коллекция фильмов
         * @return Map, где ключ — название жанра, значение — количество встреч
         * этого жанра среди фильмов
         */
        public Map<String, Long> task(@NonNull Collection<Movie> movies) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            Collection<Movie> movies = movies();

            Map<String, Long> genreOccurrenceCount = task(movies);

            assertNotNull(genreOccurrenceCount);
            assertFalse(genreOccurrenceCount.isEmpty());
            assertTrue(genreOccurrenceCount.containsKey("Drama"));
            assertTrue(genreOccurrenceCount.keySet().stream()
                    .allMatch(genreName -> genreName != null && !genreName.isBlank()));

            assertTrue(genreOccurrenceCount.values().stream()
                    .allMatch(count -> count != null && count > 0));

            genreOccurrenceCount.forEach((genreName, movieCount) ->
                    System.out.println(genreName + " " + movieCount));
        }
    }

    @Nested
    @DisplayName("MB06. Задание: Найти количество фильмов каждого режиссёра.")
    class TaskMB06 {

        /**
         * Задание: Найти количество фильмов каждого режиссёра.
         * <p>
         * Описание: необходимо пройти по всем фильмам, получить всех режиссёров и
         * посчитать, сколько раз каждое имя режиссёра встречается среди фильмов.
         * Ключом итоговой TreeMap является имя режиссёра, а значением — количество
         * встреч этого режиссёра среди фильмов. Итоговая Map должна быть отсортирована
         * по имени режиссёра в алфавитном порядке.
         *
         * @param movies коллекция фильмов
         * @return TreeMap, где ключ — имя режиссёра, значение — количество его фильмов
         */
        public TreeMap<String, Long> task(@NonNull Collection<Movie> movies) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            Collection<Movie> movies = movies();

            TreeMap<String, Long> movieCountByDirectorName = task(movies);

            assertNotNull(movieCountByDirectorName);
            assertFalse(movieCountByDirectorName.isEmpty());
            assertInstanceOf(TreeMap.class, movieCountByDirectorName);

            assertTrue(movieCountByDirectorName.values().stream().allMatch(c -> c != null && c > 0));
            assertEquals(movieCountByDirectorName.keySet().stream().sorted().toList(), new ArrayList<>(movieCountByDirectorName.keySet()));

            movieCountByDirectorName.forEach((directorName, movieCount) ->
                    System.out.printf("%-25s %d%n", directorName, movieCount));
        }
    }

    @Nested
    @DisplayName("MB07. Задание: Найти дубли фильмов по IMDb ID.")
    class TaskMB07 {

        /**
         * Задание: Найти дубли фильмов по IMDb ID.
         * <p>
         * Описание: необходимо сгруппировать фильмы по их IMDb ID и оставить только
         * те группы, в которых оказалось больше одного фильма, то есть дубликаты по
         * идентификатору. Результат возвращается в виде ассоциативного массива, где
         * ключ — IMDb ID, а значение — список фильмов с этим идентификатором.
         * <p>
         * Фильмы без IMDb ID в результат не включаются.
         *
         * @param movies коллекция фильмов
         * @return ассоциативный массив «IMDb ID → список фильмов-дубликатов»
         */
        public Map<String, List<Movie>> task(@NonNull Collection<Movie> movies) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            Collection<Movie> movies = movies();
            Map<String, List<Movie>> duplicates = task(movies);

            assertNotNull(duplicates);

            // каждая группа в результате — действительно дубликаты (>1)
            assertTrue(duplicates.values().stream().allMatch(list -> list.size() > 1));

            // все фильмы внутри группы имеют тот же IMDb ID, что и ключ
            assertTrue(duplicates.entrySet().stream()
                    .allMatch(entry -> entry.getValue().stream()
                            .allMatch(movie -> entry.getKey().equals(movie.getImdb()))));

            // граница: пустой вход
            assertTrue(task(List.of()).isEmpty());

            duplicates.forEach((imdb, list) ->
                    System.out.println(imdb + " -> " + list.size()));
        }
    }
}