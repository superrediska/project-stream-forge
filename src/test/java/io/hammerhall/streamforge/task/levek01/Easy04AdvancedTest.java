package io.hammerhall.streamforge.task.levek01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.BaseTest;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Easy Tasks: Advanced block")
class Easy04AdvancedTest extends BaseTest {

    @Nested
    @DisplayName("EA01. Задание: Получить «временной срез» базы — N самых ранних и N самых поздних фильмов.")
    class TaskEA01 {

        /**
         * Задание: Получить «временной срез» базы — N самых ранних и N самых поздних фильмов.
         * <p>
         * Описание: фильмы упорядочиваются по году выхода. Из полученной последовательности
         * формируется результат: сначала идут N самых ранних фильмов в порядке возрастания
         * года, затем — N самых поздних фильмов в порядке убывания года (от новейшего к
         * старому).
         * <p>
         * Если фильмов меньше, чем {@code 2 * limit}, один и тот же фильм может попасть
         * в обе части результата. Если коллекция пуста или {@code limit} не положителен —
         * возвращается пустой список.
         *
         * @param movies коллекция фильмов
         * @param limit  количество фильмов с каждого «края» хронологии
         * @return список из самых ранних (по возрастанию) и самых поздних (по убыванию) фильмов
         */
        public List<Movie> task(@NonNull Collection<Movie> movies, int limit) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            Collection<Movie> movies = movies();
            int limit = 3;

            List<Movie> slice = task(movies, limit);
            assertNotNull(slice);
            assertEquals(Math.min(2 * limit, 2 * movies.size()), slice.size());

            // первая половина — по возрастанию года, вторая — по убыванию
            List<Movie> oldestPart = slice.subList(0, slice.size() / 2);
            List<Movie> newestPart = slice.subList(slice.size() / 2, slice.size());
            IntStream.range(1, oldestPart.size())
                    .forEach(i -> assertTrue(oldestPart.get(i - 1).getYear() <= oldestPart.get(i).getYear()));
            IntStream.range(1, newestPart.size())
                    .forEach(i -> assertTrue(newestPart.get(i - 1).getYear() >= newestPart.get(i).getYear()));

            assertTrue(task(List.of(), 3).isEmpty());
            assertTrue(task(movies, 0).isEmpty());
            assertTrue(task(movies, -1).isEmpty());

            slice.forEach(m -> System.out.println(m.getTitle() + " (" + m.getYear() + ")"));
        }
    }

    @Nested
    @DisplayName("EA02. Задание: Отобрать страны по нескольким критериям одновременно.")
    class TaskEA02 {

        /**
         * Задание: Отобрать страны по нескольким критериям одновременно.
         * <p>
         * Описание: результат содержит страны, одновременно удовлетворяющие
         * всем следующим критериям:
         * <p>
         * 1. численность населения строго больше 10 миллионов человек;
         * 2. континент — не Антарктида;
         * 3. выполняется хотя бы одно из двух дополнительных условий:
         * 3.1. площадь территории строго больше 500 000 кв. км;
         * 3.2. плотность населения строго больше 200 чел./кв. км
         * (при положительной площади).
         * <p>
         * Критерии должны быть объединены в одно составное условие отбора.
         * <p>
         * Порядок стран в результате соответствует порядку исходного списка.
         *
         * @param countries список стран
         * @return список стран, удовлетворяющих условию отбора
         */
        public List<Country> task(@NonNull List<Country> countries) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            List<Country> countries = countries();

            List<Country> filtered = task(countries);

            assertNotNull(filtered);

            assertFalse(filtered.isEmpty());

            assertTrue(filtered.size() <= countries.size());

            assertTrue(countries.containsAll(filtered));

            assertTrue(task(List.of()).isEmpty());

            System.out.println("Отобрано стран: " + filtered.size());
            filtered.forEach(country ->
                    System.out.printf("%s | нас.: %d | площ.: %s | конт.: %s%n",
                            country.getName(),
                            country.getPopulation(),
                            country.getSurfaceArea(),
                            country.getContinent()));
        }
    }
}