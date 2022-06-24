package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.gameStrategy.Car;
import racingcar.gameStrategy.Energy;
import racingcar.gameStrategy.EnergyFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class CarTest {
    private final EnergyFactory energyFactory = mock(EnergyFactory.class);

    @DisplayName("시작 위치는 0이다")
    @Test
    void startPosition() {
        //given
        Car car = createCar();

        //when
        int position = car.position();

        //then
        assertThat(position).isZero();
    }

    @DisplayName("4 이상인 경우 전진한다")
    @Test
    void forward() {
        //given
        Car car = createCar();
        Energy forward = Energy.valueOf(4); // TODO
        given(energyFactory.random()).willReturn(forward);

        //when
        int position = car.move();

        //then
        assertThat(position).isOne();
    }

    @DisplayName("3 이하인 경우 움직이지 않는다")
    @Test
    void stop() {
        //given
        Car car = createCar();
        Energy stop = Energy.valueOf(3); // TODO
        given(energyFactory.random()).willReturn(stop);

        //when
        int position = car.move();

        //then
        assertThat(position).isZero();
    }

    private Car createCar() {
        return new Car(energyFactory, "pobi");
    }
}
