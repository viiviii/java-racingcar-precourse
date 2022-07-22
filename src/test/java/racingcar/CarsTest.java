package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.gamePlay.CarPosition;
import racingcar.gamePlay.Cars;
import racingcar.gameStrategy.Car;
import racingcar.gameStrategy.CarsImpl;
import racingcar.gameStrategy.Energy;
import racingcar.gameStrategy.EnergyFactory;

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
    private Car createCar(EnergyFactory energyFactory, String carName) {
        return new Car(energyFactory, carName);
    }

    // TODO: EnergyFactory 같은 애는 인터페이스로 해야된대
    private static final class AlwaysForward extends EnergyFactory {
        @Override
        public Energy random() {
            return Energy.valueOf(Energy.MAX); // TODO: 팩토리 메서드 일관성있게 바꾸기
        }
    }

    private static final class AlwaysStop extends EnergyFactory {
        @Override
        public Energy random() {
            return Energy.valueOf(Energy.MIN); // TODO: 팩토리 메서드 일관성있게 바꾸기
        }
    }
}
