package racingcar.race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.rule.Engine;
import racingcar.rule.Move;
import racingcar.rule.Name;
import racingcar.rule.Position;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class CarTest {
    private Engine engine = mock(Engine.class);
    private Position position = Position.start();
    private Name name = new Name("apple");
    private Car car;

    @BeforeEach
    void setUp() {
        car = Car.of(engine, name, position);
    }

    @DisplayName("자동차가 멈춰있으면 위치는 증가하지 않는다")
    @Test
    void stop() {
        //given
        given(engine.power()).willReturn(Move.STOP);

        //when
        Position position = car.move();

        //then
        assertThat(position.get()).isZero();
    }

    @DisplayName("자동차가 전진할 때 마다 위치는 1씩 증가한다")
    @Test
    void forwardMoveTwice() {
        //given
        given(engine.power()).willReturn(Move.FORWARD);

        //when
        Position firstPosition = car.move();
        Position secondsPosition = car.move();

        //then
        assertThat(firstPosition.get()).isEqualTo(1);
        assertThat(secondsPosition.get()).isEqualTo(2);
    }
}
