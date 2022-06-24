package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.gamePlay.Cars;
import racingcar.gamePlay.Record;
import racingcar.gameStrategy.Car;
import racingcar.gameStrategy.CarsImpl;
import racingcar.gameStrategy.Energy;
import racingcar.gameStrategy.EnergyFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

// TODO
class CarsTest {
    private final EnergyFactory alwaysStop = mock(EnergyFactory.class);
    private final EnergyFactory alwaysForward = mock(EnergyFactory.class);
    private final Energy STOP = Energy.valueOf(3);
    private final Energy FORWARD = Energy.valueOf(4);

    @DisplayName("자동차들이 움직인다")
    @Test
    void moves() {
        //given
        given(alwaysStop.random()).willReturn(STOP);
        given(alwaysForward.random()).willReturn(FORWARD);
        Car alwaysStopCar = createCar(alwaysStop, "pobi");
        Car alwaysForwardCar = createCar(alwaysForward, "woni");
        Cars cars = CarsImpl.of(alwaysStopCar, alwaysForwardCar);

        //when
        Record record = cars.move();

        //then
        assertThat(record.carNames()).containsExactly(alwaysStopCar.name(), alwaysForwardCar.name());
        assertThat(record.positionBy(alwaysStopCar.name())).isEqualTo(0);
        assertThat(record.positionBy(alwaysForwardCar.name())).isEqualTo(1);
    }

    private Car createCar(EnergyFactory energyFactory, String carName) {
        return new Car(energyFactory, carName);
    }
}
