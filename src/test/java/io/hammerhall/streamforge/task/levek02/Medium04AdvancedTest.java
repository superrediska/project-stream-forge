package io.hammerhall.streamforge.task.levek02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.hammerhall.streamforge.domain.movie.Director;
import io.hammerhall.streamforge.domain.movie.Movie;
import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.BaseTest;
import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Medium Tasks: Advanced block")
class Medium04AdvancedTest extends BaseTest {

    @Nested
    @DisplayName("MA01. Задание: Найти континент с максимальной плотностью населения")
    class TaskMA01 {

        /**
         * Задание: Найти континент с максимальной плотностью населения.
         * <p>
         * Описание: плотность населения континента вычисляется как отношение
         * суммарного населения всех его стран к суммарной площади этих стран.
         * Необходимо вернуть название континента с наибольшей плотностью.
         *
         * @param countries список стран
         * @return название континента с максимальной плотностью населения
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

            // граница: пустой вход → нет результата
            assertThrows(NoSuchElementException.class, () -> task(List.of()));

            // граница: одна страна → её континент и есть ответ
            Country any = countries.getFirst();
            assertEquals(any.getContinent(), task(List.of(any)));

            // граница: страна с нулевой площадью не ломает расчёт (нет деления на ноль)
            Country zeroArea = new Country();
            zeroArea.setContinent("Nowhere");
            zeroArea.setPopulation(1_000);
            zeroArea.setSurfaceArea(0.0);
            assertEquals("Nowhere", task(List.of(zeroArea)));

            // граница: при равной плотности результат — валидный континент из входа
            String result = task(countries);
            assertTrue(countries.stream()
                    .map(Country::getContinent)
                    .anyMatch(c -> c.equals(result)));

            System.out.println(continent);
        }
    }

    @Nested
    @DisplayName("MA03. Задание: Получить список всех режиссёров фильмов без создания промежуточных коллекций.")
    class TaskMA03 {

        /**
         * Задание: Получить список всех режиссёров фильмов без создания промежуточных коллекций.
         * <p>
         * Описание: каждый фильм может иметь нескольких режиссёров. Необходимо
         * извлечь всех режиссёров из всех фильмов, сохранив порядок их
         * появления (сначала все режиссёры первого фильма, затем второго и так
         * далее). Повторяющиеся режиссёры не удаляются. Для пустой коллекции
         * фильмов возвращается пустой список.
         *
         * @param movies коллекция фильмов
         * @return список всех режиссёров в порядке появления
         */
        public List<Director> task(@NonNull Collection<Movie> movies) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            Collection<Movie> movies = movies();
            List<Director> allDirectors = task(movies);

            assertNotNull(allDirectors);
            assertFalse(allDirectors.isEmpty());

            // все элементы — не null
            assertTrue(allDirectors.stream().allMatch(Objects::nonNull));

            // каждый режиссёр из результата действительно снимал хотя бы один фильм
            // из исходной коллекции (проверка пересчётом через flatMap)
            Set<Director> viaFlatMap = movies.stream()
                    .flatMap(m -> m.getDirectors().stream())
                    .collect(Collectors.toSet());
            assertTrue(viaFlatMap.containsAll(allDirectors));

            // граница: пустой вход
            assertTrue(task(List.of()).isEmpty());

            // граница: фильм без режиссёров не добавляет элементов
            Movie noDirector = new Movie();
            noDirector.setDirectors(List.of());
            assertTrue(task(List.of(noDirector)).isEmpty());

            System.out.printf("Всего режиссёров (с повторами): %d%n", allDirectors.size());
        }
    }

    @Nested
    @DisplayName("MA04. Задание: Для каждого континента построить список стран с населением более 50 миллионов.")
    class TaskMA04 {

        /**
         * Задание: Для каждого континента построить список стран с населением более 50 миллионов.
         * <p>
         * Описание: необходимо сгруппировать страны по континентам, и для каждого
         * континента отобрать только те страны, население которых строго больше
         * 50 миллионов. Результат возвращается в виде ассоциативного массива, где
         * ключ — название континента, а значение — список подходящих стран.
         * Континенты, на которых нет стран с населением более 50 миллионов,
         * представлены в результате пустым списком.
         * <p>
         * Для пустого списка стран возвращается пустой ассоциативный массив.
         *
         * @param countries список стран
         * @return ассоциативный массив «континент → список стран с населением > 50 млн»
         */
        public Map<String, List<Country>> task(@NonNull List<Country> countries) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        @Test
        void runTask() {
            List<Country> countries = countries();
            Map<String, List<Country>> result = task(countries);

            assertNotNull(result);
            assertFalse(result.isEmpty());

            // ключи — непустые названия континентов
            assertTrue(result.keySet().stream()
                    .allMatch(continent -> continent != null && !continent.isBlank()));

            // граница: страна с населением ровно 50 млн НЕ попадает (строго больше)
            Country edge = new Country();
            edge.setContinent("Test");
            edge.setPopulation(50_000_000);
            edge.setCities(List.of());
            Map<String, List<Country>> edgeResult = task(List.of(edge));
            assertTrue(edgeResult.containsKey("Test"));
            assertTrue(edgeResult.get("Test").isEmpty());

            result.forEach((continent, filteredCountries) ->
                    System.out.printf("%s -> %d стран(ы)%n",
                            continent, filteredCountries.size()));
        }
    }

    @Nested
    @DisplayName("MA05. Задание: Найти наиболее представленного режиссёра и годы его активности.")
    class TaskMA05 {

        /**
         * Задание: Найти наиболее представленного режиссёра и годы его активности.
         * <p>
         * Метки: [TIE_BREAK]
         * <p>
         * Описание: необходимо для каждого режиссёра определить количество фильмов, а также
         * первый и последний год выхода. Если у фильма несколько режиссёров, вклад
         * учитывается для каждого из них.
         * <p>
         * <b>Алгоритм:</b> каждый фильм разворачивается в пары {@code (имя режиссёра → год выхода)},
         * поэтому фильм с несколькими режиссёрами даёт несколько записей. Пары группируются
         * по имени, а годы выхода собираются в {@link IntSummaryStatistics} — этот объект
         * за один проход сам считает {@code count}, {@code min} и {@code max}, то есть
         * количество фильмов и границы активности. Из статистики формируется
         * {@link DirectorActivitySummary}.
         * <p>
         * Результат — режиссёр с наибольшим количеством фильмов; при равенстве выбирается
         * более ранний первый год, затем — лексикографически меньшее имя (через {@code min}
         * с {@code reversed()} по количеству).
         *
         * @param movies коллекция фильмов
         * @return сводная информация о наиболее представленном режиссёре
         * @throws NoSuchElementException если коллекция фильмов пустая или режиссёров нет
         */
        public DirectorActivitySummary task(@NonNull Collection<Movie> movies) {
            throw new UnsupportedOperationException("Реализуйте метод");
        }

        /**
         * Сводка активности режиссёра: количество фильмов, первый и последний год выхода.
         *
         * @param directorName имя режиссёра
         * @param movieCount   количество фильмов режиссёра
         * @param firstYear    самый ранний год выхода фильма
         * @param lastYear     самый поздний год выхода фильма
         */
        record DirectorActivitySummary(String directorName, long movieCount, int firstYear, int lastYear) {

            @Override
            public String toString() {
                return "Режиссёр: %s | Количество фильмов: %d | Первый год: %d | Последний год: %d"
                        .formatted(directorName, movieCount, firstYear, lastYear);
            }
        }

        @Test
        void runTask() {
            Collection<Movie> movies = movies();

            DirectorActivitySummary summary = task(movies);

            assertNotNull(summary);

            assertNotNull(summary.directorName());
            assertFalse(summary.directorName().isBlank());

            assertTrue(summary.movieCount() > 0);
            assertTrue(summary.firstYear() > 0 && summary.firstYear() <= summary.lastYear());
            assertThrows(NoSuchElementException.class, () -> task(List.of()));

            System.out.println(summary);
        }
    }
}
