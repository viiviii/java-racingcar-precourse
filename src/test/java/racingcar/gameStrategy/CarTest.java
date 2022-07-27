package racingcar.gameStrategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.gameStrategy.Movement.FORWARD;
import static racingcar.gameStrategy.Movement.STOP;

class CarTest {

    @DisplayName("시작 위치는 0이다")
    @Test
    void startPosition() {
        //given
        Car car = new Car(null, "pobi");

        //when
        int startPosition = car.position();

        //then
        assertThat(startPosition).isZero();
    }

    @DisplayName("자동차가 정지한 경우 위치는 그대로이다")
    @Test
    void stop() {
        //given
        MovementStrategy movementStrategyIsStop = new AlwaysReturns(STOP);
        Car car = new Car(movementStrategyIsStop, "pobi");

        //when
        car.move();

        //then
        assertThat(car.position()).isZero();
    }

    @DisplayName("자동차가 전진한 경우 위치가 1 증가한다")
    @Test
    void forward() {
        //given
        MovementStrategy movementStrategyIsForward = new AlwaysReturns(FORWARD);
        Car car = new Car(movementStrategyIsForward, "pobi");

        //when
        car.move();

        //then
        assertThat(car.position()).isOne();
    }

    private static final class AlwaysReturns implements MovementStrategy {
        private final Movement movement;

        private AlwaysReturns(Movement movement) {
            this.movement = movement;
        }

        @Override
        public Movement movement() {
            return movement;
        }
    }
}
