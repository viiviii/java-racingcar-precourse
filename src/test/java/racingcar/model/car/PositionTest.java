package racingcar.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @DisplayName("초기 값은 0이다")
    @Test
    void initialValueIsZero() {
        //given
        Position position = Position.init();

        //when
        int initialValue = position.get();

        //then
        assertThat(initialValue).isZero();
    }

    @DisplayName("값을 증가할 수 있다")
    @Test
    void increase() {
        //given
        Position position = Position.init();

        //when
        position.increase();
        int increasePosition = position.get();

        //then
        assertThat(increasePosition).isOne();
    }

    @DisplayName("copyOf은 새로운 객체를 리턴한다")
    @Test
    void copyOf() {
        //given
        Position origin = Position.init();

        //when
        Position copy = Position.copyOf(origin);
        origin.increase();

        //then
        assertThat(origin.get()).isOne();
        assertThat(copy.get()).isZero();
    }
}
