package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.gameStrategy.Car;
import racingcar.gameStrategy.MovementNumber;
import racingcar.gameStrategy.MovementNumberStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("시작 위치는 0이다")
    @Test
    void startPosition() {
        //given
        MovementNumberStrategy strategy = new AlwaysSameNumberReturn(4);
        Car car = new Car(strategy, "pobi");

        //when
        int position = car.position();

        //then
        assertThat(position).isZero();
    }

    @DisplayName("4 이상인 경우 전진한다")
    @Test
    void forward() {
        //given
        MovementNumberStrategy strategy = new AlwaysSameNumberReturn(4);
        Car car = new Car(strategy, "pobi");

        //when
        int position = car.move();

        //then
        assertThat(position).isOne();
    }

    @DisplayName("3 이하인 경우 움직이지 않는다")
    @Test
    void stop() {
        //given
        MovementNumberStrategy strategy = new AlwaysSameNumberReturn(3);
        Car car = new Car(strategy, "pobi");

        //when
        int position = car.move();

        //then
        assertThat(position).isZero();
    }

    private static final class AlwaysSameNumberReturn implements MovementNumberStrategy {
        private final int number;

        private AlwaysSameNumberReturn(int number) {
            this.number = number;
        }

        @Override
        public MovementNumber get() {
            return MovementNumber.valueOf(number);
        }
    }
}
