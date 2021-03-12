import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class JavaTest {

    /**
     * tryの括弧内で宣言している変数がCloseableかAutoCloseableの実装である場合は、自動でclose()される
     *
     * https://docs.oracle.com/javase/jp/7/technotes/guides/language/try-with-resources.html
     */
    @Test
    void try_with_resources文のメリットは何か() throws IOException {
        URL url = new URL("https://cheers.glass");
        try (InputStream in = url.openStream();) {
        }
    }

    @Test
    void 数字100000をもっとわかりやすく記述せよ() {
        assertThat(100_000).isEqualTo(100000);
    }
}
