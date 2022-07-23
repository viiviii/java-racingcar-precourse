package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.gamePlay.CarPosition;
import racingcar.gamePlay.Cars;
import racingcar.gameStrategy.Car;
import racingcar.gameStrategy.CarsImpl;
import racingcar.gameStrategy.MovementNumber;
import racingcar.gameStrategy.MovementNumberStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// TODO
class CarsTest {

    @Test
    void move() {
        //given
        // TODO: 테스트 리팩토링
        Car forwardCar = createCar(new AlwaysForward(), "pobi");
        Car stopCar = createCar(new AlwaysStop(), "woni");
        Cars cars = CarsImpl.of(forwardCar, stopCar);
        CarPosition forwardPosition = new CarPosition(forwardCar.name(), 1);
        CarPosition stoppedPosition = new CarPosition(stopCar.name(), 0);

        //when
        List<CarPosition> carMovements = cars.move();

        //then
        assertThat(carMovements).containsExactly(forwardPosition, stoppedPosition);
    }

    // TODO
    private Car createCar(MovementNumberStrategy movementNumberStrategy, String carName) {
        return new Car(movementNumberStrategy, carName);
    }

    private static final class AlwaysForward implements MovementNumberStrategy {

        @Override
        public MovementNumber get() {
            return MovementNumber.valueOf(MovementNumber.MAX);
        }
    }

    private static final class AlwaysStop implements MovementNumberStrategy {
        @Override
        public MovementNumber get() {
            return MovementNumber.valueOf(MovementNumber.MIN);
        }
    }
}
