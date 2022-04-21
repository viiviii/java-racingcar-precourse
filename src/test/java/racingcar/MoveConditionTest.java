package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.MoveCondition.MAX_STOP_CONDITION;
import static racingcar.MoveCondition.MIN_FORWARD_CONDITION;

public class MoveConditionTest {

    @DisplayName("4 이상이면 전진이다")
    @Test
    void moveWhenMoreThan4() {
        //given
        MoveCondition moveCondition = new MoveCondition(MIN_FORWARD_CONDITION);

        //when
        boolean actual = moveCondition.isMove();

        //then
        assertThat(actual).isTrue();
    }

    @DisplayName("4 미만이면 멈춤이다")
    @Test
    void stopWhenLessThan4() {
        //given
        MoveCondition moveCondition = new MoveCondition(MAX_STOP_CONDITION);

        //when
        boolean actual = moveCondition.isStop();

        //then
        assertThat(actual).isTrue();
    }
}
