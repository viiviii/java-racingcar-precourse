package racingcar.gameStrategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.gamePlay.Movement.FORWARD;
import static racingcar.gamePlay.Movement.STOP;

class MovementStrategyRandomTest {

    private final MovementStrategy movementStrategy = new MovementStrategyRandom();

    @DisplayName("랜덤 값이 4 이상일 경우 전진")
    @Test
    void forwardWhenMoreThanFour() {
        assertRandomNumberInRangeTest(
                () -> assertThat(movementStrategy.movement()).isEqualTo(FORWARD),
                4);
    }

    @DisplayName("랜덤 값이 4 미만이면 정지")
    @Test
    void stopWhenLessThanFour() {
        assertRandomNumberInRangeTest(
                () -> assertThat(movementStrategy.movement()).isEqualTo(STOP),
                3);
    }
}