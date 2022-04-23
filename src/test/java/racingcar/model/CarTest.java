package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Engine engine = new Engine();
    private CarName carName = new CarName("apple");
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(engine, carName);
    }

    @DisplayName("자동차는 1회 전진했다")
    @Test
    void forwardOnce() {
        //given
        Energy energy = Energy.fromInteger(4); // TODO: 하드코딩 제거

        //when
        MoveResult result = car.moveBy(energy);
        Position actual = result.position();

        //then
        assertThat(actual.get()).isOne();
    }

    @DisplayName("자동차는 1회 멈춰있다")
    @Test
    void stopOnce() {
        //given
        Energy energy = Energy.fromInteger(4 - 1); // TODO: 하드코딩 제거

        //when
        MoveResult result = car.moveBy(energy);
        Position actual = result.position();

        //then
        assertThat(actual.get()).isZero();
    }

    @DisplayName("자동차가 2회 전진했다")
    @Test
    void forwardTwice() {
        //given
        Energy energy = Energy.fromInteger(4); // TODO: 하드코딩 제거

        //when
        MoveResult firstResult = car.moveBy(energy);
        MoveResult secondResult = car.moveBy(energy);

        Position firstPosition = firstResult.position();
        Position secondsPosition = secondResult.position();

        //then
        assertThat(firstPosition.get()).isEqualTo(1);
        assertThat(secondsPosition.get()).isEqualTo(2);
    }

    @DisplayName("자동차가 2회 멈춰있다")
    @Test
    void stopTwice() {
        //given
        Energy energy = Energy.fromInteger(4 - 1); // TODO: 하드코딩 제거

        //when
        MoveResult firstResult = car.moveBy(energy);
        MoveResult secondResult = car.moveBy(energy);

        Position firstPosition = firstResult.position(); // TODO: moveResult - 바로 원시값 리턴할까?
        Position secondsPosition = secondResult.position();

        //then
        assertThat(firstPosition.get()).isZero();
        assertThat(secondsPosition.get()).isZero();
    }

    @DisplayName("자동차가 1회 전진하고 1회 멈춰있다")
    @Test
    void forwardAndStop() {
        // given
        Energy forwardEnergy = Energy.fromInteger(4); // TODO: 하드코딩 제거
        Energy lessEnergy = Energy.fromInteger(4 - 1); // TODO: 하드코딩 제거

        //when
        MoveResult firstResult = car.moveBy(forwardEnergy);
        MoveResult secondResult = car.moveBy(lessEnergy);

        Position firstPosition = firstResult.position();
        Position secondsPosition = secondResult.position();

        //then
        assertThat(firstPosition.get()).isOne();
        assertThat(secondsPosition.get()).isOne();
    }
}
