package racingcar.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class PositionTest {

    @DisplayName("포지션을 증가할 수 있다")
    @Test
    void increase() {
        //given
        Position position = Position.fromZero();

        //when
        position.increase();

        //then
        assertThat(position.get()).isOne();
    }

    @DisplayName("포지션이 음수인 경우 예외가 발생한다")
    @Test
    void throwExceptionWhenNegativePosition() {
        //given
        int negative = -1;

        //when
        Throwable thrown = catchThrowable(() -> Position.from(negative));


        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
