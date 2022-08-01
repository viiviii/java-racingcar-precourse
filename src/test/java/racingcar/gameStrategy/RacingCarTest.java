package racingcar.gameStrategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.gameStrategy.Movement.FORWARD;
import static racingcar.gameStrategy.Movement.STOP;

class RacingCarTest {

    @DisplayName("이동 시 전진한 자동차는 위치가 1 증가한다")
    @Test
    void forward() {
        //given
        String carName = "pobi";
        MovementStrategy alwaysForward = new Always(FORWARD);

        //when
        RacingCar car = new RacingCar(alwaysForward, carName);
        car.move();

        //then
        assertThat(car.position()).isOne();
    }

    @DisplayName("이동 시 정지한 자동차는 위치가 증가하지 않는다")
    @Test
    void stop() {
        //given
        String carName = "pobi";
        MovementStrategy alwaysStop = new Always(STOP);

        //when
        RacingCar car = new RacingCar(alwaysStop, carName);
        car.move();

        //then
        assertThat(car.position()).isZero();
    }

    private static final class Always implements MovementStrategy {
        private final Movement movement;

        private Always(Movement movement) {
            this.movement = movement;
        }

        @Override
        public Movement movement() {
            return movement;
        }
    }
}