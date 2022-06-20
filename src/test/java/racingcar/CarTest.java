package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    ControllerTest.Car car = new CarImpl();

    @DisplayName("4 이상인 경우 전진한다")
    @Test
    void forward() {
        //given
        int forward = 4;

        //when
        boolean moved = car.move(forward);

        //then
        assertThat(moved).isTrue();
    }

    @DisplayName("3 이하인 경우 정지한다")
    @Test
    void stop() {
        //given
        int stop = 3;

        //when
        boolean moved = car.move(stop);

        //then
        assertThat(moved).isFalse();
    }

    public static final class CarImpl implements ControllerTest.Car {

        @Override
        public boolean move(int number) {
            return number > 3;
        }
    }
}
