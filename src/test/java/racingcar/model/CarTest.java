package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class CarTest {
    private Engine engine = mock(Engine.class);
    private MyRandoms myRandoms = new MyRandoms();
    private CarName carName = new CarName("apple");
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(engine, myRandoms, carName);
    }

    @DisplayName("자동차는 1회 전진했다")
    @Test
    void forwardOnce() {
        //given
        given(engine.powerBy(anyInt())).willReturn(Move.FORWARD);

        //when
        MoveResult result = car.move();
        Position actual = result.position();

        //then
        assertThat(actual.get()).isOne();
    }

    @DisplayName("자동차는 1회 멈춰있다")
    @Test
    void stopOnce() {
        //given
        given(engine.powerBy(anyInt())).willReturn(Move.STOP);

        //when
        MoveResult result = car.move();
        Position actual = result.position();

        //then
        assertThat(actual.get()).isZero();
    }

    @DisplayName("자동차가 2회 전진했다")
    @Test
    void forwardTwice() {
        //given
        given(engine.powerBy(anyInt())).willReturn(Move.FORWARD, Move.FORWARD);

        //when
        MoveResult firstResult = car.move();
        MoveResult secondResult = car.move();

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
        given(engine.powerBy(anyInt())).willReturn(Move.STOP, Move.STOP);

        //when
        MoveResult firstResult = car.move();
        MoveResult secondResult = car.move();

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
        given(engine.powerBy(anyInt())).willReturn(Move.FORWARD, Move.STOP);

        //when
        MoveResult firstResult = car.move();
        MoveResult secondResult = car.move();

        Position firstPosition = firstResult.position();
        Position secondsPosition = secondResult.position();

        //then
        assertThat(firstPosition.get()).isOne();
        assertThat(secondsPosition.get()).isOne();
    }
}
