package racingcar.gameStrategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.gamePlay.Movement;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.gamePlay.Movement.FORWARD;
import static racingcar.gamePlay.Movement.STOP;

class CarTest {

    @DisplayName("자동차가 정지했다")
    @Test
    void stop() {
        //given
        Movement expectedMovement = STOP;
        Car car = new Car(new AlwaysReturns(expectedMovement), "pobi");

        //when
        Movement movement = car.move();

        //then
        assertThat(movement).isEqualTo(expectedMovement);
    }

    @DisplayName("자동차가 전진했다")
    @Test
    void forward() {
        //given
        Movement expectedMovement = FORWARD;
        Car car = new Car(new AlwaysReturns(expectedMovement), "pobi");

        //when
        Movement movement = car.move();

        //then
        assertThat(movement).isEqualTo(expectedMovement);
    }

    private static final class AlwaysReturns implements MovementStrategy {
        private final Movement movement;

        private AlwaysReturns(Movement movement) {
            this.movement = movement;
        }

        @Override
        public Movement movement() {
            return movement;
        }
    }
}
