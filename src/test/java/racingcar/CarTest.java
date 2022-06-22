package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.gamePlay.Car;
import racingcar.gameStrategy.CarImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class CarTest {
    private final MyRandom myRandom = mock(MyRandom.class);


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
        int forward = 4;
        given(myRandom.pickNumberInRage(anyInt(), anyInt())).willReturn(forward); // TODO
        Car car = createCar();

        //when
        int position = car.move();

        //then
        assertThat(position).isOne();
    }

    @DisplayName("3 이하인 경우 움직이지 않는다")
    @Test
    void stop() {
        //given
        int stop = 3;
        given(myRandom.pickNumberInRage(anyInt(), anyInt())).willReturn(stop); // TODO
        Car car = createCar();

        //when
        int position = car.move();

        //then
        assertThat(position).isZero();
    }

    private Car createCar() {
        return new CarImpl(myRandom, "pobi"); // TODO
    }
}
