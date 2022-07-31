package racingcar.gameStrategy;

import org.junit.jupiter.api.Test;
import racingcar.gamePlay.Car;
import racingcar.gamePlay.Movement;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.gamePlay.Movement.FORWARD;

class RacingCarImplTest {

    @Test
    void name() {
        //given
        String carName = "pobi";
        MovementStrategy movementStrategy = new Always(FORWARD);

        //when
        Car car = new RacingCar(movementStrategy, carName);

        //then
        assertThat(car.name()).isEqualTo(carName);
        assertThat(car.state().forwardCount()).isZero();
    }

    @Test
    void move() {
        //given
        String carName = "pobi";
        MovementStrategy movementStrategy = new Always(FORWARD);

        //when
        Car car = new RacingCar(movementStrategy, carName);
        car.move();

        //then
        assertThat(car.state().forwardCount()).isOne();
    }

    private static final class Always implements MovementStrategy {
        private final Movement movement;

        private Always(Movement movement) {
            this.movement = movement;
        }

        @Override
        public Movement movement() {
            return movement;
        }
    }
}