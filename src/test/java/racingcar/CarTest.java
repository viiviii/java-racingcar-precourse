package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.gameStrategy.CarImpl;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("시작 위치는 0이다")
    @Test
    void startPosition() {
        //given
        CarImpl car = createCar();

        //when
        int position = car.position();

        //then
        assertThat(position).isZero();
    }

    @DisplayName("4 이상인 경우 전진한다")
    @Test
    void forward() {
        //given
        int forward = 4;
        CarImpl car = createCar();

        //when
        int position = car.move(forward);

        //then
        assertThat(position).isOne();
    }

    @DisplayName("3 이하인 경우 움직이지 않는다")
    @Test
    void stop() {
        //given
        int stop = 3;
        CarImpl car = createCar();

        //when
        int position = car.move(stop);

        //then
        assertThat(position).isZero();
    }

    private CarImpl createCar() {
        return new CarImpl("pobi");
    }
}
