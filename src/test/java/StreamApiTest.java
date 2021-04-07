import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamApiTest {

    @Test
    void 数値のリストの要素をそれぞれ2倍にしたリストを生成せよ() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        List<Integer> newList = list.stream().map(l -> l * 2).collect(Collectors.toList());

        assertThat(newList).containsExactly(2, 4, 6, 8, 10);
    }

    @Test
    void 数値のリストから偶数のみ取り出して新しいリストを生成せよ() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        List<Integer> newList = list.stream().filter(l -> l % 2 == 0).collect(Collectors.toList());

        assertThat(newList).containsExactly(2, 4);
    }

    @Test
    void map化() {
        List<Person> list = Person.getList();
        Map<String, Person> collect = list.stream().collect(Collectors.toMap(l -> l.getName(), l -> l));

        assertThat(collect).containsEntry("name", new Person("name", 26));
        assertThat(collect).containsEntry("name2", new Person("name2", 32));
        assertThat(collect).containsEntry("name3", new Person("name3", 26));
    }

    @Test
    void map化重複削除() {
        List<Person> list = Person.getList();
        Map<Integer, Person> collect = list.stream().collect(Collectors.toMap(l -> l.getAge(), l -> l, (a, b) -> {
            return a;
        }));

        assertThat(collect).containsEntry(26, new Person("name", 26));
        assertThat(collect).containsEntry(32, new Person("name2", 32));
    }

    @Data
    @AllArgsConstructor
    static class Person {
        private String name;
        private int age;

        static List<Person> getList() {
            return List.of(
                    new Person("name", 26),
                    new Person("name2", 32),
                    new Person("name3", 26)
            );
        }
    }
}
