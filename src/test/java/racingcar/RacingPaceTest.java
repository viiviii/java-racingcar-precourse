package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingPaceTest {
    
    @DisplayName("자동차 전진 상태는 -로 나타낸다")
    @Test
    void move() {
        //given
        MoveCondition run = new MoveCondition(MoveCondition.MIN_FORWARD_CONDITION);

        //when
        String str = racingPace(run);

        //then
        Assertions.assertThat(str).isEqualTo("-");
    }

    @DisplayName("자동차가 멈춤 상태이면 빈 문자열로 나타낸다")
    @Test
    void move() {
        //given
        MoveCondition run = new MoveCondition(MoveCondition.MIN_FORWARD_CONDITION - 1);

        //when
        String str = racingPace(run);

        //then
        Assertions.assertThat(str).isEmpty();
    }
}
