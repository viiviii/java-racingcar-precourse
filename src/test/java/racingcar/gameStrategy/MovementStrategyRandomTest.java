package racingcar.gameStrategy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.gameStrategy.Movement.FORWARD;
import static racingcar.gameStrategy.Movement.STOP;

class MovementStrategyRandomTest {

    private final MovementStrategy movementStrategy = new MovementStrategyRandom();

    @ParameterizedTest(name = "랜덤 값이 4 이상이면 전진: value={0}")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void forwardWhenMoreThanFour(int randomNumber) {
        assertRandomNumberInRangeTest(
                () -> assertThat(movementStrategy.movement()).isEqualTo(FORWARD),
                randomNumber);
    }

    @ParameterizedTest(name = "랜덤 값이 4 미만이면 정지: value={0}")
    @ValueSource(ints = {1, 2, 3})
    void stopWhenLessThanFour(int randomNumber) {
        assertRandomNumberInRangeTest(
                () -> assertThat(movementStrategy.movement()).isEqualTo(STOP),
                randomNumber);
    }
}