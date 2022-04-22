package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.model.MoveCondition.FORWARD;
import static racingcar.model.MoveCondition.STOP;

public class MoveConditionTest {

    @DisplayName("4 이상이면 전진이다")
    @Test
    void forwardWhenMoreThan4() {
        //given
        MoveCondition moveCondition = new MoveCondition(FORWARD);

        //when
        boolean actual = moveCondition.isForward();

        //then
        assertThat(actual).isTrue();
    }

    @DisplayName("4 미만이면 멈춤이다")
    @Test
    void stopWhenLessThan4() {
        //given
        MoveCondition moveCondition = new MoveCondition(STOP);

        //when
        boolean actual = moveCondition.isForward();

        //then
        assertThat(actual).isFalse();
    }
}
