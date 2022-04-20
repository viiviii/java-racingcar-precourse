package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomTest {

    @DisplayName("4 이상이면 전진이다")
    @Test
    void moveWhenMoreThan4() {
        //given
        int value = 4;

        //when
        String actual = run(value);


        //then
        assertThat(actual).isEqualTo("전진");
    }

    @DisplayName("4 미만이면 멈춤이다")
    @Test
    void moveWhenLessThan4() {
        //given
        int value = 3;

        //when
        String actual = run(value);


        //then
        assertThat(actual).isEqualTo("멈춤");
    }

    private String run(int i) {
        if(i < 4) {
            return "멈춤";
        }
        return "전진";
    }
}
