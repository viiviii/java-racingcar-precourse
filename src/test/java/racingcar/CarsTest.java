package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.gamePlay.Car;
import racingcar.gamePlay.Cars;
import racingcar.gamePlay.Record;
import racingcar.gameStrategy.CarImpl;
import racingcar.gameStrategy.RandomMoveCars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class CarsTest {
    private final MyRandom random1 = mock(MyRandom.class);
    private final MyRandom random2 = mock(MyRandom.class);

    private final int STOP = 3;
    private final int FORWARD = 4;

    @DisplayName("자동차들이 움직인다")
    @Test
    void moves() {
        //given
        given(random1.pickNumberInRage(anyInt(), anyInt())).willReturn(STOP); // TODO
        given(random2.pickNumberInRage(anyInt(), anyInt())).willReturn(FORWARD); // TODO
        Car car1 = createCar(random1, "pobi");
        Car car2 = createCar(random2, "woni");
        Cars cars = RandomMoveCars.of(car1, car2);

        //when
        Record record = cars.move();

        //then
        assertThat(record.carNames()).containsExactly(car1.name(), car2.name());
        assertThat(record.positionBy(car1.name())).isZero();
        assertThat(record.positionBy(car2.name())).isOne();
    }

    private Car createCar(MyRandom myRandom, String carName) {
        return new CarImpl(myRandom, carName);
    }
}
