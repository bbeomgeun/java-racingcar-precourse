package racingcar.view;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    @Test
    public void 문자열_입력_테스트() {
        String test = "HI,HELLO,i";
        List<String> strings = Arrays.asList(test.split(","));

        long count = strings.stream().filter(v -> v.length() > 1).count();

        assertThat(count).isEqualTo(2L);
    }
}
