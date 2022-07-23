package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.gameStrategy.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("시작 위치는 0이다")
    @Test
    void startPosition() {
        //given
        MovementStrategy movementStrategy = new AlwaysReturns(Movement.STOP);
        Car car = new Car(movementStrategy, "pobi");

        //when
        int startPosition = car.position();

        //then
        assertThat(startPosition).isZero();
    }

    @DisplayName("자동차가 정지한 경우 위치는 그대로이다")
    @Test
    void stopped() {
        //given
        MovementStrategy movementStrategy = new AlwaysReturns(Movement.STOP);
        Car car = new Car(movementStrategy, "pobi");

        //when
        int position = car.move();

        //then
        assertThat(position).isZero();
    }

    @DisplayName("자동차가 전진한 경우 위치가 1 증가한다")
    @Test
    void movingForward() {
        //given
        MovementStrategy movementStrategy = new AlwaysReturns(Movement.FORWARD);
        Car car = new Car(movementStrategy, "pobi");

        //when
        int position = car.move();

        //then
        assertThat(position).isOne();
    }

    private static final class AlwaysReturns implements MovementStrategy {
        private final Movement movement;

        private AlwaysReturns(Movement movement) {
            this.movement = movement;
        }

        @Override
        public Movement get() {
            return movement;
        }
    }

    private interface MovementStrategy {

        Movement get();
    }

    private enum Movement {
        FORWARD, STOP
    }
}
