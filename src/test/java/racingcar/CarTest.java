package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("4 이상이면 전진이다")
    @Test
    void moveWhenMoreThan4() {
        //given
        int value = 4;

        //when
        String actual = Car.run(value);

        //then
        assertThat(actual).isEqualTo("전진");
    }

    @DisplayName("4 미만이면 멈춤이다")
    @Test
    void stopWhenLessThan4() {
        //given
        int value = 3;

        //when
        String actual = Car.run(value);

        //then
        assertThat(actual).isEqualTo("멈춤");
    }
}
