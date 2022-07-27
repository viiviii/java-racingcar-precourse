package racingcar.gameStrategy;

import org.junit.jupiter.api.Test;
import racingcar.gamePlay.CarPosition;
import racingcar.gamePlay.Cars;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.gameStrategy.Movement.FORWARD;
import static racingcar.gameStrategy.Movement.STOP;

// TODO
class CarsTest {

    @Test
    void move() {
        //given
        // TODO: 테스트 리팩토링
        Car forwardCar = createCarThatAlways(FORWARD, "pobi");
        Car stopCar = createCarThatAlways(STOP, "woni");
        Cars cars = CarsImpl.of(forwardCar, stopCar);
        CarPosition forwardPosition = new CarPosition(forwardCar.name(), 1);
        CarPosition stoppedPosition = new CarPosition(stopCar.name(), 0);

        //when
        cars.move();

        //then
        assertThat(cars.positions()).containsExactly(forwardPosition, stoppedPosition);
    }

    // TODO
    private Car createCarThatAlways(Movement movement, String carName) {
        final MovementStrategy movementStrategy = new AlwaysReturns(movement);
        return new Car(movementStrategy, carName);
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
