package racingcar.race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.rule.Energy;
import racingcar.rule.Engine;
import racingcar.rule.Position;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private Engine engine = new Engine();
    private Position position = Position.start();
    private Position otherPosition = new Position(3);
    private String name = "apple";
    private Car car;

    @BeforeEach
    void setUp() {
        car = Car.of(engine, position, name);
    }

    @DisplayName("다른 자동차와 위치 비교")
    @Test
    void comparePositionTo() {
        //given
        Car sameCar = createCar(position, "same");
        Car frontCar = createCar(otherPosition, "front");

        //then
        assertThat(car.comparePositionTo(frontCar)).isEqualTo(-1);
        assertThat(car.comparePositionTo(sameCar)).isEqualTo(0);
        assertThat(frontCar.comparePositionTo(car)).isEqualTo(1);
    }

    @DisplayName("자동차가 해당 위치에 있으면 true")
    @Test
    void returnTrueWhenSamePosition() {
        //when
        boolean actual = car.inPosition(position);

        //then
        assertThat(actual).isTrue();
    }

    @DisplayName("자동차가 해당 위치가 아니면 false를 리턴한다")
    @Test
    void returnFalseWhenDifferencePosition() {
        //when
        boolean actual = car.inPosition(otherPosition);

        //then
        assertThat(actual).isFalse();
    }

    @DisplayName("자동차가 멈춰있으면 위치는 증가하지 않는다")
    @Test
    void stopOnce() {
        //given
        Energy stop = Energy.from(Engine.FORWARD_ENERGY.get() - 1);

        //when
        Position position = car.moveBy(stop);

        //then
        assertThat(position.get()).isZero();
    }

    @DisplayName("자동차가 전진할 때 마다 위치는 1씩 증가한다")
    @Test
    void forwardTwice() {
        //given
        Energy forward = Engine.FORWARD_ENERGY;

        //when
        Position firstPosition = car.moveBy(forward);
        Position secondsPosition = car.moveBy(forward);

        //then
        assertThat(firstPosition.get()).isEqualTo(1);
        assertThat(secondsPosition.get()).isEqualTo(2);
    }

    private Car createCar(Position position, String name) {
        return Car.of(engine, position, name); // TODO
    }
}
