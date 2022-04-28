package racingcar.rule;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class NameDelimiterTest {

    @DisplayName("쉼표로 구분된 문자열로 Name 목록을 만든다")
    @Test
    void split() {
        //given
        String model = "pobi,crong,honux";
        NameDelimiter nameDelimiter = new NameDelimiter();

        //when
        List<Name> names = nameDelimiter.delimit(model);

        //then
        assertThat(names).hasSize(3);
    }
}