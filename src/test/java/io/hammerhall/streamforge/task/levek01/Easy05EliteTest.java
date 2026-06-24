package io.hammerhall.streamforge.task.levek01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.world.City;
import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.BaseTest;
import java.util.List;
import java.util.Objects;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Easy05EliteTest extends BaseTest {

    @Nested
    @DisplayName("EE01. Задание: Сопоставить странам их города-столицы.")
    class TaskEE01 {

        /**
         * Задание: Сопоставить странам их города-столицы.
         * <p>
         * Описание: по всем городам строится индекс, позволяющий находить город
         * по его идентификатору. Затем для каждой страны из индекса извлекается
         * город, идентификатор которого совпадает с {@code capital} этой страны.
         * <p>
         * Если для страны соответствующий город в данных отсутствует, такая страна
         * в результат не попадает. Порядок городов-столиц соответствует порядку
         * обхода исходного списка стран.
         *
         * @param countries список стран
         * @return список городов-столиц, найденных по идентификатору
         */
        public List<City> task(@NonNull List<Country> countries) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            List<Country> countries = countries();

            List<City> capitals = task(countries);

            assertNotNull(capitals);
            assertFalse(capitals.isEmpty());
            assertTrue(capitals.size() <= countries.size());
            assertTrue(capitals.stream().allMatch(Objects::nonNull));

            assertTrue(task(List.of()).isEmpty());

            Country noCapitalMatch = new Country();
            noCapitalMatch.setCapital(-1);
            noCapitalMatch.setCities(List.of());
            assertTrue(task(List.of(noCapitalMatch)).isEmpty());

            capitals.forEach(c -> System.out.println(c.getName() + " (id=" + c.getId() + ")"));
        }
    }

    @Nested
    @DisplayName("EE02. Задание: Построить последовательность роста населения.")
    class TaskEE02 {

        /**
         * Задание: Построить последовательность роста населения.
         * <p>
         * Описание: необходимо сформировать последовательность значений
         * численности населения, начиная с указанного стартового значения.
         * Каждое следующее значение вычисляется увеличением предыдущего
         * на заданный процент.
         * <p>
         * Генерация завершается при достижении верхней границы.
         * В результирующий список должны попасть все полученные значения
         * в порядке их генерации.
         *
         * @param startPopulation начальная численность населения
         * @param growthRate      ежегодный прирост в процентах
         * @param maxPopulation   верхняя граница генерации
         * @return последовательность значений численности населения
         */
        public List<Long> task(long startPopulation, double growthRate, long maxPopulation) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            long startPopulation = 1_000_000L;
            double growthRate = 5.0;
            long maxPopulation = 2_000_000L;

            List<Long> populationSequence = task(startPopulation, growthRate, maxPopulation);

            assertNotNull(populationSequence);
            assertFalse(populationSequence.isEmpty());

            assertEquals(startPopulation, populationSequence.getFirst());

            assertTrue(populationSequence.getLast() < maxPopulation);

            assertTrue(task(2_000_000L, 5.0, 2_000_000L).isEmpty());

            List<Long> single = task(100L, 1.0, 101L);
            assertEquals(1, single.size());
            assertEquals(100L, single.getFirst());

            System.out.println("Последовательность роста населения:");
            populationSequence.forEach(System.out::println);
        }
    }
}
