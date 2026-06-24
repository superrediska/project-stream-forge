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
import java.util.Optional;
import java.util.Set;
import java.util.stream.IntStream;
import lombok.NonNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Easy Tasks: Basic block")
public class Easy02BasicTest extends BaseTest {

    @Nested
    @DisplayName("EB01. Задание: Найти первый фильм, вышедший после указанного года.")
    class TaskEB01 {

        /**
         * Задание: Найти первый фильм, вышедший после указанного года.
         * <p>
         * Описание: необходимо отфильтровать фильмы, оставив те, у которых год выхода
         * строго больше {@code targetYear}, и вернуть первый из них в порядке обхода
         * исходной коллекции.
         *
         * @param movies     коллекция фильмов
         * @param targetYear пороговый год; в результат попадают фильмы с годом строго больше
         * @return Optional с первым (в порядке обхода) фильмом, вышедшим после
         * {@code targetYear}, или {@code Optional.empty()}, если такого фильма нет
         */
        public Optional<Movie> task(@NonNull Collection<Movie> movies, int targetYear) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            Collection<Movie> movies = movies();

            int targetYear = 2000;

            Optional<Movie> firstMovieAfterYear = task(movies, targetYear);

            assertNotNull(firstMovieAfterYear);
            assertTrue(firstMovieAfterYear.isPresent());
            Optional<Movie> movieAfterFutureYear = task(movies, 3000);
            assertNotNull(movieAfterFutureYear);
            assertTrue(movieAfterFutureYear.isEmpty());

            firstMovieAfterYear.ifPresentOrElse(System.out::println, () -> System.out.println("Фильм не найден"));
        }
    }

    @Nested
    @DisplayName("EB02. Задание: Посчитать количество фильмов, вышедших в годы, которые не являются високосными.")
    class TaskEB02 {

        /**
         * Задание: Посчитать количество фильмов, вышедших в годы, которые не являются високосными.
         * <p>
         * Описание: необходимо посчитать, сколько фильмов из исходной коллекции вышло в годы,
         * не являющиеся високосными. Год, делящийся на 4, не всегда является високосным —
         * воспользуйтесь стандартным Java API для точной проверки.
         *
         * @param movies коллекция фильмов
         * @return количество фильмов, вышедших в невисокосные годы
         */
        public long task(@NonNull Collection<Movie> movies) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            Collection<Movie> movies = movies();

            long nonLeapYearMoviesCount = task(movies);

            assertTrue(nonLeapYearMoviesCount > 0);
            assertTrue(nonLeapYearMoviesCount <= movies.size());
            assertEquals(0L, task(List.of()));

            System.out.println(nonLeapYearMoviesCount);
        }
    }

    @Nested
    @DisplayName("EB03. Задание: Получить список всех фильмов, отсортированных по году выхода.")
    class TaskEB03 {

        /**
         * Задание: Получить список всех фильмов, отсортированных по году выхода.
         * <p>
         * Описание: необходимо отсортировать коллекцию фильмов по году выхода в порядке
         * возрастания — от более старых фильмов к более новым.
         *
         * @param movies коллекция фильмов
         * @return список фильмов, отсортированных по году выхода по возрастанию
         */
        public List<Movie> task(@NonNull Collection<Movie> movies) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            Collection<Movie> movies = movies();

            List<Movie> moviesSortedByYear = task(movies);

            assertNotNull(moviesSortedByYear);
            assertEquals(movies.size(), moviesSortedByYear.size());
            assertTrue(moviesSortedByYear.containsAll(movies));
            IntStream.range(1, moviesSortedByYear.size())
                    .mapToObj(i -> moviesSortedByYear.get(i - 1).getYear() <= moviesSortedByYear.get(i).getYear())
                    .forEach(Assertions::assertTrue);

            moviesSortedByYear.forEach(System.out::println);
        }
    }

    @Nested
    @DisplayName("EB04. Задание: Получить названия фильмов, отсортированные по году выхода от новых к старым.")
    class TaskEB04 {

        /**
         * Задание: Получить названия фильмов, упорядоченные по году выхода от новых к старым.
         * <p>
         * Описание: результатом является список названий всех фильмов из исходной коллекции,
         * отсортированных по убыванию года выхода: сначала идут названия самых новых фильмов,
         * затем — более старых.
         * <p>
         * Порядок названий фильмов с одинаковым годом выхода не регламентирован.
         *
         * @param movies коллекция фильмов
         * @return список названий фильмов в порядке убывания года выхода
         */
        public List<String> task(@NonNull Collection<Movie> movies) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            Collection<Movie> movies = movies();

            List<String> movieTitlesSortedByYearDesc = task(movies);

            assertNotNull(movieTitlesSortedByYearDesc);
            assertEquals(movies.size(), movieTitlesSortedByYearDesc.size());
            assertTrue(movieTitlesSortedByYearDesc.stream()
                    .allMatch(title -> title != null && !title.isBlank()));

            movieTitlesSortedByYearDesc.forEach(System.out::println);
        }
    }

    @Nested
    @DisplayName("EB05. Задание: Проверить, есть ли в базе хотя бы один фильм указанного жанра.")
    class TaskEB05 {

        /**
         * Задание: Проверить, есть ли в базе хотя бы один фильм указанного жанра.
         * <p>
         * Описание: необходимо проверить, существует ли среди всех фильмов хотя бы один,
         * у которого в списке жанров присутствует указанный жанр. Сравнение выполняется
         * по названию жанра.
         *
         * @param movies    коллекция фильмов
         * @param genreName название жанра, наличие которого нужно проверить
         * @return true, если в базе есть хотя бы один фильм указанного жанра, иначе false
         */
        public boolean task(@NonNull Collection<Movie> movies, @NonNull String genreName) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            Collection<Movie> movies = movies();

            String genreName = "Drama";

            boolean hasMoviesWithGenre = task(movies, genreName);

            assertTrue(hasMoviesWithGenre);
            assertFalse(task(movies, "__unknown_genre__"));
            assertFalse(task(movies, ""));

            System.out.println(hasMoviesWithGenre);
        }
    }

    @Nested
    @DisplayName("EB06. Задание: Получить неизменяемый список стран, отсортированных по убыванию численности населения.")
    class TaskEB06 {

        /**
         * Задание: Получить неизменяемый список стран, отсортированных по убыванию численности населения.
         * <p>
         * Описание: результатом является список всех стран из исходного набора,
         * упорядоченный от самой населённой страны к наименее населённой.
         * Полученный список должен быть защищён от модификации — любая попытка
         * добавить или удалить элемент должна приводить к исключению.
         *
         * @param countries список всех стран мира
         * @return неизменяемый список стран, отсортированных по населению по убыванию
         */
        public List<Country> task(@NonNull List<Country> countries) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            List<Country> countries = countries();
            List<Country> largestCountries = task(countries);

            assertNotNull(largestCountries);
            assertFalse(largestCountries.isEmpty());
            assertEquals(countries.size(), largestCountries.size());

            assertThrows(UnsupportedOperationException.class, () -> largestCountries.add(new Country()));

            largestCountries
                    .forEach(country -> System.out.printf("%s — %d%n", country.getName(), country.getPopulation()));
        }
    }

    @Nested
    @DisplayName("EB07. Задание: Получить список названий всех уникальных жанров, отсортированный по алфавиту.")
    class TaskEB07 {

        /**
         * Задание: Получить список названий всех уникальных жанров, отсортированный по алфавиту.
         * <p>
         * Описание: необходимо собрать названия всех жанров, встречающихся в коллекции фильмов,
         * исключить дубликаты и вернуть итоговый список в алфавитном порядке.
         *
         * @param movies коллекция фильмов
         * @return список уникальных названий жанров, отсортированный по алфавиту
         */
        public List<String> task(@NonNull Collection<Movie> movies) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            Collection<Movie> movies = movies();

            List<String> uniqueGenreNames = task(movies);

            assertNotNull(uniqueGenreNames);
            assertFalse(uniqueGenreNames.isEmpty());
            assertTrue(uniqueGenreNames.stream().allMatch(name -> name != null && !name.isBlank()));

            uniqueGenreNames.forEach(System.out::println);
        }
    }

    @Nested
    @DisplayName("EB08. Задание: Получить список всех городов мира.")
    class TaskEB08 {

        /**
         * Задание: Получить список всех городов мира.
         * <p>
         * Описание: необходимо собрать все города, находящиеся в каждой стране,
         * и вернуть их единым плоским списком.
         *
         * @param countries список стран мира
         * @return список всех городов мира
         */
        public List<City> task(@NonNull List<Country> countries) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            List<Country> countries = countries();

            List<City> allCities = task(countries);

            assertNotNull(allCities);
            assertFalse(allCities.isEmpty());

            assertTrue(task(List.of()).isEmpty());

            System.out.println("Всего городов: " + allCities.size());
            allCities.forEach(System.out::println);
        }
    }

    @Nested
    @DisplayName("EB09. Получить список фильмов с некорректным или отсутствующим IMDb ID.")
    class TaskEB09 {

        /**
         * Задание: Получить список фильмов с некорректным или отсутствующим IMDb ID.
         * <p>
         * Описание: IMDb ID считается корректным, если он не равен {@code null}
         * и соответствует регулярному выражению {@code tt\\d+}
         * (префикс «tt», за которым следует одна или более цифр).
         * Результатом является список фильмов, у которых IMDb ID отсутствует
         * или имеет неверный формат.
         * <p>
         * Порядок фильмов в результате соответствует порядку обхода исходной коллекции.
         *
         * @param movies коллекция фильмов
         * @return список фильмов с отсутствующим или некорректным IMDb ID
         */
        public List<Movie> task(@NonNull Collection<Movie> movies) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            Collection<Movie> movies = movies();
            List<Movie> moviesWithInvalidImdb = task(movies);

            assertNotNull(moviesWithInvalidImdb);

            System.out.println("Фильмов с некорректным IMDb ID: " + moviesWithInvalidImdb.size());
            moviesWithInvalidImdb
                    .forEach(movie -> System.out.printf("  %s — IMDb: %s%n", movie.getTitle(), movie.getImdb()));
        }
    }

    @Nested
    @DisplayName("EB10. Задание: Получить список названий всех стран, отсортированный в алфавитном порядке.")
    class TaskEB10 {

        /**
         * Задание: Получить список названий всех стран,
         * отсортированный в алфавитном порядке.
         * <p>
         * Описание: необходимо преобразовать список стран в список их названий
         * и отсортировать по алфавиту (лексикографически).
         *
         * @param countries список стран
         * @return список названий стран, отсортированный по алфавиту
         */
        public List<String> task(@NonNull List<Country> countries) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            List<Country> countries = countries();
            List<String> countryNames = task(countries);

            assertNotNull(countryNames);
            assertFalse(countryNames.isEmpty());
            assertEquals(countries.size(), countryNames.size());

            assertTrue(countryNames.stream()
                    .allMatch(name -> name != null && !name.isBlank()));

            assertTrue(task(List.of()).isEmpty());

            countryNames.forEach(System.out::println);
        }
    }

    @Nested
    @DisplayName("EB11. Задание: Получить список стран с населением более 50 миллионов человек.")
    class TaskEB11 {

        /**
         * Задание: Получить список стран с населением более 50 миллионов человек.
         * <p>
         * Описание: необходимо отфильтровать страны, оставив только те,
         * численность населения которых строго больше 50 000 000.
         *
         * @param countries список стран
         * @return список стран с населением > 50 000 000
         */
        public List<Country> task(@NonNull List<Country> countries) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            List<Country> countries = countries();
            List<Country> largeCountries = task(countries);

            assertNotNull(largeCountries);
            assertFalse(largeCountries.isEmpty());

            assertTrue(task(List.of()).isEmpty());

            largeCountries.forEach(country -> System.out.printf("%s — %d%n", country.getName(), country.getPopulation()));
        }
    }

    @Nested
    @DisplayName("EB12. Задание: Получить множество всех континентов.")
    class TaskEB12 {

        /**
         * Задание: Получить множество всех континентов.
         * <p>
         * Описание: необходимо собрать уникальные названия континентов,
         * на которых расположены страны из базы данных.
         *
         * @param countries список стран
         * @return множество уникальных названий континентов
         */
        public Set<String> task(@NonNull List<Country> countries) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            List<Country> countries = countries();
            Set<String> continents = task(countries);

            assertNotNull(continents);
            assertFalse(continents.isEmpty());

            assertFalse(continents.contains(null));

            assertTrue(continents.stream()
                    .allMatch(continentName -> continentName != null && !continentName.isBlank()));

            assertTrue(task(List.of()).isEmpty());

            System.out.println("Континенты: " + continents);
        }
    }

    @Nested
    @DisplayName("EB13. Задание: Найти страну с наибольшей площадью.")
    class TaskEB13 {

        /**
         * Задание: Найти страну с наибольшей площадью.
         * <p>
         * Описание: необходимо найти страну, у которой значение
         * {@code surfaceArea} максимально среди всех стран.
         *
         * @param countries список стран
         * @return {@code Optional}, содержащий страну с наибольшей площадью,
         *         или {@code Optional.empty()}, если список стран пуст
         */
        public Optional<Country> task(@NonNull List<Country> countries) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            List<Country> countries = countries();
            Optional<Country> largestByArea = task(countries);

            assertNotNull(largestByArea);
            assertTrue(largestByArea.isPresent());

            Country largest = largestByArea.get();

            assertTrue(task(List.of()).isEmpty());

            System.out.printf("Страна с наибольшей площадью: %s — %s%n", largest.getName(), largest.getSurfaceArea());
        }
    }

    @Nested
    @DisplayName("EB14. Задание: Найти самый ранний фильм в базе.")
    class TaskEB14 {

        /**
         * Задание: Найти самый ранний фильм в базе.
         * <p>
         * Описание: необходимо найти фильм с минимальным годом выхода среди всех
         * фильмов из исходной коллекции. Если несколько фильмов имеют одинаковый
         * минимальный год, допускается вернуть любой из них. Если коллекция фильмов
         * пустая, результатом должен быть Optional.empty().
         *
         * @param movies коллекция фильмов
         * @return Optional с самым ранним фильмом или Optional.empty(),
         * если коллекция пуста
         */
        public Optional<Movie> task(@NonNull Collection<Movie> movies) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            Collection<Movie> movies = movies();

            Optional<Movie> earliestMovie = task(movies);

            assertNotNull(earliestMovie);
            assertTrue(earliestMovie.isPresent());

            Movie earliestMovieValue = earliestMovie.orElseThrow();

            assertNotNull(earliestMovieValue.getTitle());
            assertFalse(earliestMovieValue.getTitle().isBlank());
            assertTrue(earliestMovieValue.getYear() > 0);
            assertTrue(movies.stream()
                    .allMatch(movie -> movie.getYear() >= earliestMovieValue.getYear()));
            assertTrue(task(List.of()).isEmpty());

            earliestMovie.ifPresent(System.out::println);
        }
    }

    @Nested
    @DisplayName("EB15 Задание: Найти самый поздний фильм в базе.")
    class TaskEB15 {

        /**
         * Задание: Найти самый поздний фильм в базе.
         * <p>
         * Описание: необходимо найти фильм с максимальным годом выхода среди всех
         * фильмов из исходной коллекции. Если несколько фильмов имеют одинаковый
         * максимальный год, допускается вернуть любой из них. Если коллекция фильмов
         * пустая, результатом должен быть Optional.empty().
         *
         * @param movies коллекция фильмов
         * @return Optional с самым поздним фильмом или Optional.empty(),
         * если коллекция пуста
         */
        public Optional<Movie> task(@NonNull Collection<Movie> movies) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            Collection<Movie> movies = movies();

            Optional<Movie> latestMovie = task(movies);

            assertNotNull(latestMovie);
            assertTrue(latestMovie.isPresent());

            Movie latestMovieValue = latestMovie.orElseThrow();

            assertNotNull(latestMovieValue.getTitle());
            assertFalse(latestMovieValue.getTitle().isBlank());
            assertTrue(latestMovieValue.getYear() > 0);
            assertTrue(movies.stream()
                    .allMatch(movie -> movie.getYear() <= latestMovieValue.getYear()));
            assertTrue(task(List.of()).isEmpty());

            latestMovie.ifPresent(System.out::println);
        }
    }

    @Nested
    @DisplayName("EB16. Задание: Найти все фильмы заданного жанра.")
    class TaskEB16 {

        /**
         * Задание: Найти все фильмы заданного жанра.
         * <p>
         * Описание: необходимо отфильтровать коллекцию фильмов и оставить только те,
         * у которых среди жанров присутствует жанр с указанным названием.
         * Сравнение выполняется по названию жанра.
         *
         * @param movies    коллекция фильмов
         * @param genreName название жанра, фильмы которого нужно найти
         * @return список фильмов указанного жанра
         */
        public List<Movie> task(@NonNull Collection<Movie> movies, @NonNull String genreName) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            Collection<Movie> movies = movies();

            String genreName = "Drama";

            List<Movie> moviesByGenre = task(movies, genreName);

            assertNotNull(moviesByGenre);
            assertFalse(moviesByGenre.isEmpty());
            assertTrue(moviesByGenre.size() <= movies.size());
            assertTrue(movies.containsAll(moviesByGenre));
            assertTrue(task(movies, "__unknown_genre__").isEmpty());

            moviesByGenre.forEach(System.out::println);
        }
    }

    @Nested
    @DisplayName("EB17. Задание: Найти все фильмы заданного режиссёра.")
    class TaskEB17 {

        /**
         * Задание: Найти все фильмы заданного режиссёра.
         * <p>
         * Описание: необходимо отфильтровать коллекцию фильмов и оставить только те,
         * у которых среди режиссёров присутствует режиссёр с указанным именем.
         * Сравнение выполняется по имени режиссёра.
         *
         * @param movies       коллекция фильмов
         * @param directorName имя режиссёра, фильмы которого нужно найти
         * @return список фильмов указанного режиссёра
         */
        public List<Movie> task(@NonNull Collection<Movie> movies, @NonNull String directorName) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            Collection<Movie> movies = movies();

            String directorName = "Tim Burton";

            List<Movie> moviesByDirector = task(movies, directorName);

            assertNotNull(moviesByDirector);
            assertFalse(moviesByDirector.isEmpty());
            assertTrue(moviesByDirector.size() <= movies.size());
            assertTrue(movies.containsAll(moviesByDirector));
            assertTrue(task(movies, "__unknown_director__").isEmpty());

            moviesByDirector.forEach(System.out::println);
        }
    }
}
