package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveConditionTest {

    @DisplayName("4 이상이면 전진이다")
    @Test
    void forwardWhenMoreThan4() {
        //given
        MoveCondition moveCondition = new MoveCondition();

        //when
        Move move = moveCondition.checkBy(4); // TODO: 하드코딩 제거

        //then
        assertThat(move.isForward()).isTrue();
    }

    @DisplayName("4 미만이면 멈춤이다")
    @Test
    void stopWhenLessThan4() {
        //given
        MoveCondition moveCondition = new MoveCondition();

        //when
        Move move = moveCondition.checkBy(4 - 1); // TODO: 하드코딩 제거

        //then
        assertThat(move.isStop()).isTrue();
    }
}
