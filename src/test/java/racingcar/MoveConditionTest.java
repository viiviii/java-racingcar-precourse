package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveConditionTest {

    @DisplayName("4 이상이면 전진이다")
    @Test
    void moveWhenMoreThan4() {
        //given
        int moreThan4 = 4;

        //when
        boolean actual = new MoveCondition(moreThan4).isMove();

        //then
        assertThat(actual).isTrue();
    }

    @DisplayName("4 미만이면 멈춤이다")
    @Test
    void stopWhenLessThan4() {
        //given
        int lessThan4 = 3;

        //when
        boolean actual = new MoveCondition(lessThan4).isStop();

        //then
        assertThat(actual).isTrue();
    }
}
