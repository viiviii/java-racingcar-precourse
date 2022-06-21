package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class CarsTest {
    private final MyRandom myRandom = mock(MyRandom.class);
    private final int FORWARD = 4;

    @DisplayName("자동차들이 움직인다")
    @Test
    void moves() {
        //given
        given(myRandom.pickNumberInRage(anyInt(), anyInt())).willReturn(FORWARD);
        Car car1 = createCar("pobi");
        Car car2 = createCar("woni");
        Cars cars = Cars.of(myRandom, car1, car2);

        //when
        Record record = cars.move();

        //then
        assertThat(record.carNames()).containsExactly(car1.name(), car2.name());
        assertThat(record.positionBy(car1.name())).isEqualTo(1);
        assertThat(record.positionBy(car2.name())).isEqualTo(1);
    }

    private Car createCar(String carName) {
        return new CarImpl(carName);
    }
}
