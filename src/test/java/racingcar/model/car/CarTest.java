package racingcar.model.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Energy;
import racingcar.model.MoveResult;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private CarName carName = new CarName("apple");
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(carName);
    }

    @DisplayName("자동차가 멈춰있으면 위치는 증가하지 않는다")
    @Test
    void stopOnce() {
        //given
        Energy energy = lessEnergy();

        //when
        MoveResult result = car.moveBy(energy);
        Position actual = result.position();

        //then
        assertThat(actual.get()).isZero();
    }

    @DisplayName("자동차가 전진할 때 마다 위치는 1씩 증가한다")
    @Test
    void forwardTwice() {
        //given
        Energy energy = forwardEnergy();

        //when
        MoveResult firstResult = car.moveBy(energy);
        MoveResult secondResult = car.moveBy(energy);

        Position firstPosition = firstResult.position(); // TODO: moveResult - 바로 원시값 리턴할까?
        Position secondsPosition = secondResult.position();

        //then
        assertThat(firstPosition.get()).isEqualTo(1);
        assertThat(secondsPosition.get()).isEqualTo(2);
    }

    private Energy forwardEnergy() {
        return Energy.fromInteger(Engine.MIN_FORWARD_ENERGY);
    }

    private Energy lessEnergy() {
        return Energy.fromInteger(Engine.MIN_FORWARD_ENERGY - 1);
    }
}
