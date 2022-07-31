package racingcar.gameStrategy;

import org.junit.jupiter.api.Test;
import racingcar.gamePlay.Cars;
import racingcar.gamePlay.Movement;
import racingcar.gamePlay.Records;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.gamePlay.Movement.FORWARD;
import static racingcar.gamePlay.Movement.STOP;

// TODO
class CarsTest {

    @Test
    void move() {
        //given
        // TODO: 테스트 리팩토링
        Car forwardCar = createCarThatAlways(FORWARD, "pobi");
        Car stopCar = createCarThatAlways(STOP, "woni");
        Cars cars = CarsImpl.of(forwardCar, stopCar);

        //when
        cars.move();
        Records records = cars.records();

        //then
        assertThat(records.recordOf(forwardCar.name())).containsExactly(FORWARD);
        assertThat(records.recordOf(stopCar.name())).containsExactly(STOP);
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
