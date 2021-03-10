import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class OptionalTest {

    @Test
    void test() {
        Optional<Integer> integer = Optional.of(1);
        assertThat(integer.get()).isEqualTo(1);
    }
}
