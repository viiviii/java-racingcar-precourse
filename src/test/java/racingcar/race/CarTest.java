package racingcar.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.rule.Energy;
import racingcar.rule.Engine;
import racingcar.rule.Position;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private String name = "apple";

    @DisplayName("다른 자동차와 같은 위치면 0을 리턴한다")
    @Test
    void compareToPositionWhenEquals() {
        //given
        int samePosition = 3;
        Car car = Car.of("pobi", samePosition);
        Car other = Car.of("other", samePosition);

        //when
        int actual = car.compareToPosition(other);

        //then
        assertThat(actual).isZero();
    }

    @DisplayName("다른 자동차보다 위치가 앞에 있으면 1을 리턴한다")
    @Test
    void compareToPositionWhenFront() {
        //given
        Car car = Car.of("pobi", 5);
        Car other = Car.of("other", 1);

        //when
        int actual = car.compareToPosition(other);

        //then
        assertThat(actual).isEqualTo(1);
    }

    @DisplayName("다른 자동차보다 위치가 뒤에 있으면 -1을 리턴한다")
    @Test
    void compareToPositionWhenBack() {
        //given
        Car car = Car.of("pobi", 1);
        Car other = Car.of("other", 5);

        //when
        int actual = car.compareToPosition(other);

        //then
        assertThat(actual).isEqualTo(-1);
    }

    @DisplayName("자동차가 해당 위치에 있으면 true")
    @Test
    void returnTrueWhenSamePosition() {
        //given
        Position samePosition = new Position(5);
        Car car = Car.of("pobi", samePosition.get());

        //when
        boolean actual = car.inPosition(samePosition);

        //then
        assertThat(actual).isTrue();
    }

    @DisplayName("자동차가 해당 위치가 아니면 false를 리턴한다")
    @Test
    void returnFalseWhenDifferencePosition() {
        //given
        int position = 5;
        Car car = Car.of("pobi", position);

        //when
        Position other = new Position(3);
        boolean actual = car.inPosition(other);

        //then
        assertThat(actual).isFalse();
    }

    @DisplayName("자동차가 멈춰있으면 위치는 증가하지 않는다")
    @Test
    void stopOnce() {
        //given
        Car car = Car.inStartingPositionWith(name);

        //when
        Position position = car.moveBy(lessEnergy());

        //then
        assertThat(position.get()).isZero();
    }

    @DisplayName("자동차가 전진할 때 마다 위치는 1씩 증가한다")
    @Test
    void forwardTwice() {
        //given
        Car car = Car.inStartingPositionWith(name);

        //when
        Position firstPosition = car.moveBy(forwardEnergy());
        Position secondsPosition = car.moveBy(forwardEnergy());

        //then
        assertThat(firstPosition.get()).isEqualTo(1);
        assertThat(secondsPosition.get()).isEqualTo(2);
    }

    private Energy forwardEnergy() {
        return Engine.MIN_FORWARD_ENERGY;
    }

    private Energy lessEnergy() {
        final int lessThanForwardEnergy = Engine.MIN_FORWARD_ENERGY.get() - 1;
        return Energy.from(lessThanForwardEnergy);
    }
}
