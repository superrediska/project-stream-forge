package io.hammerhall.streamforge.task.levek02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.movie.Genre;
import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.domain.world.City;
import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.BaseTest;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.IntStream;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Medium Tasks: Core block")
class Medium03CoreTest extends BaseTest {

    @Nested
    @DisplayName("MC01. Задание: Найти самый густонаселённый город на каждом континенте.")
    class TaskMC01 {

        /**
         * Задание: Найти самый густонаселённый город на каждом континенте.
         * <p>
         * Описание: каждый город принадлежит стране, а страна расположена на
         * континенте. Необходимо для каждого континента определить город с
         * наибольшим населением среди всех городов его стран. Результат
         * возвращается в виде ассоциативного массива, где ключ — название
         * континента, а значение — самый густонаселённый город этого континента.
         * <p>
         * Для пустого списка стран возвращается пустой ассоциативный массив.
         *
         * @param countries список стран
         * @return ассоциативный массив «континент → самый населённый город»
         */
        public Map<String, City> task(@NonNull List<Country> countries) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            List<Country> countries = countries();
            Map<String, City> result = task(countries);

            assertNotNull(result);
            assertFalse(result.isEmpty());

            // у каждого континента есть город с положительным населением
            assertTrue(result.values().stream()
                    .allMatch(city -> city != null && city.getPopulation() > 0));

            // ключи — непустые названия континентов
            assertTrue(result.keySet().stream()
                    .allMatch(continent -> continent != null && !continent.isBlank()));

            // граница: пустой вход
            assertTrue(task(List.of()).isEmpty());

            result.forEach((continent, city) ->
                    System.out.printf("%s - %s (%d)%n", continent, city.getName(), city.getPopulation()));
        }
    }

    @Nested
    @DisplayName("MC02. Задание: Найти столицу с наибольшей численностью населения на каждом континенте.")
    class TaskMC02 {

        /**
         * Задание: Найти столицу с наибольшей численностью населения на каждом континенте.
         * <p>
         * Метки: [TIE_BREAK]
         * <p>
         * Описание: столица страны определяется как город из списка городов страны,
         * идентификатор которого совпадает с {@code capital}. Необходимо для каждого
         * континента среди столиц его стран найти столицу с наибольшим населением.
         * Результат возвращается в виде ассоциативного массива, где ключ — название
         * континента, а значение — столица с наибольшим населением на этом континенте.
         * <p>
         * Страны, для которых столица не найдена среди их городов, не учитываются.
         * Если на континенте несколько столиц с одинаковым (максимальным) населением,
         * выбирается город, название которого идёт раньше в алфавитном порядке.
         * <p>
         * Для пустого списка стран возвращается пустой ассоциативный массив.
         *
         * @param countries список стран
         * @return ассоциативный массив «континент → столица с наибольшим населением»
         */
        public Map<String, City> task(@NonNull List<Country> countries) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            List<Country> countries = countries();
            Map<String, City> result = task(countries);

            assertNotNull(result);
            assertFalse(result.isEmpty());

            // значения — столицы с положительным населением
            assertTrue(result.values().stream()
                    .allMatch(city -> city != null && city.getPopulation() > 0));

            // ключи — непустые названия континентов
            assertTrue(result.keySet().stream()
                    .allMatch(continent -> continent != null && !continent.isBlank()));

            // граница: пустой вход
            assertTrue(task(List.of()).isEmpty());

            // граница: страна без подходящей столицы не даёт записи
            Country noCapital = new Country();
            noCapital.setContinent("Nowhere");
            noCapital.setCapital(-1);
            noCapital.setCities(List.of());
            assertTrue(task(List.of(noCapital)).isEmpty());

            result.forEach((continent, city) ->
                    System.out.printf("%s -> %s (%d)%n",
                            continent, city.getName(), city.getPopulation()));
        }
    }

    @Nested
    @DisplayName("MC03. Задание: Найти континент с самым большим суммарным населением стран")
    class TaskMC03 {

        /**
         * Задание: Найти континент с самым большим суммарным населением стран.
         * <p>
         * Описание: необходимо для каждого континента сложить население всех его
         * стран и вернуть название континента, у которого суммарное население
         * наибольшее.
         *
         * @param countries список стран
         * @return название континента с максимальным суммарным населением
         * @throws NoSuchElementException если список стран пуст
         */
        public String task(@NonNull List<Country> countries) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            List<Country> countries = countries();
            String continent = task(countries);

            assertNotNull(continent);
            assertFalse(continent.isBlank());

            // граница: пустой вход
            assertThrows(NoSuchElementException.class, () -> task(List.of()));

            System.out.println(continent);
        }
    }

    @Nested
    @DisplayName("MC04. Задание: Найти страну с максимальным количеством городов на каждом континенте.")
    class TaskMC04 {

        /**
         * Задание: Найти страну с максимальным количеством городов на каждом континенте.
         * <p>
         * Метки: [TIE_BREAK]
         * <p>
         * Описание: необходимо для каждого континента определить страну, у которой
         * наибольшее количество городов. Результат возвращается в виде ассоциативного
         * массива, где ключ — название континента, а значение — страна этого
         * континента с максимальным числом городов.
         * <p>
         * Если на континенте несколько стран с одинаковым (максимальным) числом
         * городов, выбирается страна, название которой идёт раньше в алфавитном
         * порядке.
         * <p>
         * Для пустого списка стран возвращается пустой ассоциативный массив.
         *
         * @param countries список стран
         * @return ассоциативный массив «континент → страна с наибольшим числом городов»
         */
        public Map<String, Country> task(@NonNull List<Country> countries) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            List<Country> countries = countries();

            Map<String, Country> result = task(countries);

            assertNotNull(result);
            assertFalse(result.isEmpty());

            // ключи — непустые названия континентов, значения — не null
            assertTrue(result.keySet().stream()
                    .allMatch(continent -> continent != null && !continent.isBlank()));
            assertTrue(result.values().stream().allMatch(Objects::nonNull));

            // выбранная страна действительно с того же континента, что и ключ
            assertTrue(result.entrySet().stream()
                    .allMatch(entry -> entry.getKey().equals(entry.getValue().getContinent())));

            // граница: пустой вход
            assertTrue(task(List.of()).isEmpty());

            result.forEach((continent, country) ->
                    System.out.printf("%s -> %s (%d городов)%n",
                            continent, country.getName(), country.getCities().size()));
        }
    }

    @Nested
    @DisplayName("MC05. Задание: Найти среднее население городов по каждому континенту")
    class TaskMC05 {

        /**
         * Задание: Найти среднее население городов по каждому континенту.
         * <p>
         * Описание: каждый город принадлежит стране, а страна расположена на
         * континенте. Необходимо сгруппировать все города по континентам их стран
         * и для каждого континента вычислить среднее население входящих в него
         * городов. Результат возвращается в виде ассоциативного массива, где ключ —
         * название континента, а значение — среднее население его городов.
         * <p>
         * Для пустого списка стран возвращается пустой ассоциативный массив.
         *
         * @param countries список стран
         * @return ассоциативный массив «континент → среднее население городов»
         */
        public Map<String, Double> task(@NonNull List<Country> countries) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            List<Country> countries = countries();
            Map<String, Double> result = task(countries);

            assertNotNull(result);
            assertFalse(result.isEmpty());

            // средние значения положительны
            assertTrue(result.values().stream().allMatch(avg -> avg > 0));

            // ключи — непустые названия континентов
            assertTrue(result.keySet().stream()
                    .allMatch(continent -> continent != null && !continent.isBlank()));

            // граница: пустой вход
            assertTrue(task(List.of()).isEmpty());

            result.forEach((continent, avg) ->
                    System.out.printf("%s -> %.2f%n", continent, avg));
        }
    }

    @Nested
    @DisplayName("MC06. Задание: Найти все фильмы, у которых набор жанров строго равен набору: Drama и Comedy.")
    class TaskMC06 {

        /**
         * Задание: Найти все фильмы, у которых набор жанров строго равен набору: Drama и Comedy.
         * <p>
         * Описание: необходимо найти фильмы, у которых множество названий жанров
         * состоит ровно из двух значений: "Drama" и "Comedy". Фильм попадает в результат
         * только при полном совпадении наборов — ни больше, ни меньше.
         * Например, фильм с жанрами Drama, Comedy и Romance не подходит.
         *
         * @param movies коллекция фильмов
         * @return список фильмов, у которых набор жанров строго равен {"Drama", "Comedy"}
         */
        public List<Movie> task(@NonNull Collection<Movie> movies) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            Collection<Movie> movies = movies();

            List<Movie> dramaComedyMovies = task(movies);

            assertNotNull(dramaComedyMovies);
            assertFalse(dramaComedyMovies.isEmpty());
            assertTrue(dramaComedyMovies.stream()
                    .noneMatch(movie -> movie.getGenres().size() > 2));

            dramaComedyMovies.forEach(movie -> System.out.println(movie.getTitle() + " " + movie.getGenres()));
        }
    }

    @Nested
    @DisplayName("MC07. Задание: Найти год, в котором вышло больше всего фильмов.")
    class TaskMC07 {

        /**
         * Задание: Найти год, в котором вышло больше всего фильмов.
         * <p>
         * Метки: [TIE_BREAK]
         * <p>
         * Описание: необходимо сгруппировать фильмы по году выхода, посчитать
         * количество фильмов для каждого года, а затем найти год с максимальным
         * количеством фильмов.
         * <p>
         * Если несколько лет имеют одинаковое максимальное количество фильмов,
         * результатом должен стать наиболее поздний из таких годов.
         *
         * @param movies коллекция фильмов
         * @return год и количество вышедших в нём фильмов
         * @throws NoSuchElementException если коллекция фильмов пустая
         */
        public YearMovieCount task(@NonNull Collection<Movie> movies) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        /**
         * Год и количество фильмов, выпущенных в этом году.
         *
         * @param year       год выхода фильмов
         * @param movieCount количество фильмов за этот год
         */
        record YearMovieCount(int year, long movieCount) {

            @Override
            public String toString() {
                return "Год: %d | Количество фильмов: %d".formatted(year, movieCount);
            }
        }

        @Test
        void runTask() {
            Collection<Movie> movies = movies();

            YearMovieCount yearMovieCount = task(movies);

            assertNotNull(yearMovieCount);
            assertTrue(yearMovieCount.year() > 0);
            assertTrue(yearMovieCount.movieCount() > 0);
            assertThrows(NoSuchElementException.class, () -> task(List.of()));

            Movie any = movies.iterator().next();
            YearMovieCount single = task(List.of(any));
            assertEquals(any.getYear(), single.year());
            assertEquals(1L, single.movieCount());

            System.out.println(yearMovieCount);
        }
    }

    @Nested
    @DisplayName("MC08. Задание: Найти название самого популярного жанра по количеству фильмов.")
    class TaskMC08 {

        /**
         * Задание: Найти название самого популярного жанра по количеству фильмов.
         * <p>
         * Метки: [TIE_BREAK]
         * <p>
         * Описание: необходимо определить жанр, который чаще всего встречается в жанровых
         * списках фильмов. Для этого нужно пройти по всем фильмам, получить все их жанры,
         * посчитать количество встреч каждого жанра и выбрать жанр с максимальным количеством.
         * <p>
         * Результатом является название жанра, который встречается чаще всего.
         * <p>
         * Если несколько жанров имеют одинаковое количество встреч, необходимо вернуть
         * название жанра, которое идёт позже по алфавиту.
         *
         * @param movies коллекция фильмов
         * @return название самого популярного жанра
         * @throws NoSuchElementException если коллекция фильмов пустая
         *                                или не найдено ни одного жанра
         */
        public String task(@NonNull Collection<Movie> movies) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            Collection<Movie> movies = movies();

            String mostPopularGenre = task(movies);

            assertNotNull(mostPopularGenre);
            assertFalse(mostPopularGenre.isBlank());

            // граница: пустой вход
            assertThrows(NoSuchElementException.class, () -> task(List.of()));

            // граница: один фильм → один из его жанров (решение не раскрывает)
            Movie any = movies.iterator().next();
            String single = task(List.of(any));
            assertTrue(any.getGenres().stream()
                    .map(Genre::getName)
                    .anyMatch(single::equals));

            System.out.println(mostPopularGenre);
        }
    }

    @Nested
    @DisplayName("MC09. Задание: Найти страны, где население столицы составляет больше 30% населения страны")
    class TaskMC09 {

        /**
         * Задание: Найти страны, где население столицы составляет больше 30% населения страны.
         * <p>
         * Описание: для каждой страны её столица определяется как город из списка
         * городов страны, идентификатор которого совпадает с {@code capital}. Страна
         * попадает в результат, если население найденной столицы строго больше 30%
         * населения самой страны.
         * <p>
         * Страны, для которых столица не найдена или население которых равно нулю,
         * в результат не включаются. Порядок стран соответствует исходному списку.
         *
         * @param countries список стран
         * @return список стран, удовлетворяющих условию
         */
        public List<Country> task(@NonNull List<Country> countries) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            List<Country> countries = countries();

            List<Country> result = task(countries);

            assertNotNull(result);
            assertTrue(countries.containsAll(result));

            // граница: пустой вход
            assertTrue(task(List.of()).isEmpty());

            // граница: страна без подходящей столицы не проходит
            Country noCapital = new Country();
            noCapital.setPopulation(1_000_000);
            noCapital.setCapital(-1);
            noCapital.setCities(List.of());
            assertFalse(task(List.of(noCapital)).contains(noCapital));

            result.forEach(country -> System.out.println(country.getName()));
        }
    }

    @Nested
    @DisplayName("MC10. Задание: Найти топ-5 самых населённых городов мира вместе со страной и континентом")
    class TaskMC10 {

        /**
         * Задание: Найти топ-5 самых населённых городов мира вместе со страной и континентом.
         * <p>
         * Описание: среди всех городов всех стран необходимо выбрать пять городов
         * с наибольшим населением (в порядке убывания населения) и для каждого
         * вернуть его название, название страны, континент и население.
         * <p>
         * Если суммарное количество городов меньше пяти, возвращаются все города.
         * Для пустого списка стран возвращается пустой список.
         *
         * @param countries список стран
         * @return список из не более чем пяти описаний самых населённых городов,
         * упорядоченный по убыванию населения
         */
        public List<CityInfo> task(@NonNull List<Country> countries) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        /**
         * Описание города: название города, страна, континент и население.
         *
         * @param cityName    название города
         * @param countryName название страны, которой принадлежит город
         * @param continent   название континента страны
         * @param population  население города
         */
        public record CityInfo(String cityName, String countryName, String continent, int population) {

            @Override
            public String toString() {
                return "%s | %s | %s | %d".formatted(cityName, countryName, continent, population);
            }
        }

        @Test
        void runTask() {
            List<Country> countries = countries();
            List<CityInfo> result = task(countries);

            assertNotNull(result);
            assertFalse(result.isEmpty());

            // не больше пяти
            assertTrue(result.size() <= 5);

            // отсортировано по убыванию населения
            assertTrue(IntStream.range(0, result.size() - 1)
                    .allMatch(i -> result.get(i).population() >= result.get(i + 1).population()));

            // поля заполнены
            assertTrue(result.stream().allMatch(info ->
                    info.cityName() != null && !info.cityName().isBlank()
                            && info.countryName() != null && !info.countryName().isBlank()
                            && info.continent() != null && !info.continent().isBlank()
                            && info.population() > 0));

            // граница: пустой вход
            assertTrue(task(List.of()).isEmpty());

            result.forEach(System.out::println);
        }
    }

    @Nested
    @DisplayName("MC11. Задание: Найти страны, где самый большой город не является столицей")
    class TaskMC11 {

        /**
         * Задание: Найти страны, где самый большой город не является столицей.
         * <p>
         * Описание: для каждой страны самым большим городом считается город с
         * наибольшим населением среди её городов. Страна попадает в результат,
         * если идентификатор её самого большого города не совпадает с
         * идентификатором столицы ({@code capital}).
         * <p>
         * Страны без городов в результат не включаются. Порядок стран
         * соответствует исходному списку. Для пустого списка стран возвращается
         * пустой список.
         *
         * @param countries список стран
         * @return список стран, у которых самый большой город не является столицей
         */
        public List<Country> task(@NonNull List<Country> countries) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            List<Country> countries = countries();
            List<Country> result = task(countries);

            assertNotNull(result);
            assertTrue(countries.containsAll(result));

            // у каждой страны в результате крупнейший город != столица
            assertTrue(result.stream().allMatch(country -> {
                City largest = country.getCities().stream()
                        .max(Comparator.comparingInt(City::getPopulation))
                        .orElseThrow();
                return largest.getId() != country.getCapital();
            }));

            // граница: пустой вход
            assertTrue(task(List.of()).isEmpty());

            // граница: страна без городов не проходит
            Country noCities = new Country();
            noCities.setCapital(1);
            noCities.setCities(List.of());
            assertFalse(task(List.of(noCities)).contains(noCities));

            result.forEach(country -> System.out.println(country.getName()));
        }
    }

    @Nested
    @DisplayName("MC12. Задание: Найти страны, где сумма населения городов больше населения страны")
    class TaskMC12 {

        /**
         * Задание: Найти страны, где сумма населения городов больше населения страны.
         * <p>
         * Описание: для каждой страны вычисляется суммарное население всех её
         * городов. Страна попадает в результат, если эта сумма строго больше
         * населения самой страны ({@code population}).
         * <p>
         * Порядок стран соответствует исходному списку. Для пустого списка стран
         * возвращается пустой список.
         *
         * @param countries список стран
         * @return список стран, у которых суммарное население городов больше
         * населения страны
         */
        public List<Country> task(@NonNull List<Country> countries) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            List<Country> countries = countries();
            List<Country> result = task(countries);

            assertNotNull(result);
            assertTrue(countries.containsAll(result));

            // у каждой страны в результате сумма городов действительно больше населения
            assertTrue(result.stream().allMatch(country ->
                    country.getCities().stream().mapToLong(City::getPopulation).sum()
                            > country.getPopulation()));

            // граница: пустой вход
            assertTrue(task(List.of()).isEmpty());

            // граница: страна без городов не проходит (0 не больше населения >= 0)
            Country noCities = new Country();
            noCities.setPopulation(1_000);
            noCities.setCities(List.of());
            assertFalse(task(List.of(noCities)).contains(noCities));

            result.forEach(country -> System.out.printf("%s — города: %d, страна: %d%n",
                    country.getName(),
                    country.getCities().stream().mapToLong(City::getPopulation).sum(),
                    country.getPopulation()));
        }
    }
}
