package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
