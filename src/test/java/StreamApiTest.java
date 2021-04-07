import org.junit.jupiter.api.Test;

import java.util.List;
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
}
