package racingcar.gameStrategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @DisplayName("초기 위치는 0이다")
    @Test
    void init() {
        //given
        Position zero = Position.valueOf(0);

        //when
        Position initPosition = Position.init();

        //then
        assertThat(initPosition).isEqualTo(zero);
    }

    @DisplayName("위치가 1 증가한다")
    @Test
    void increase() {
        //given
        Position zero = Position.valueOf(0);
        Position one = Position.valueOf(1);

        //when
        Position increasedPosition = zero.increase();

        //then
        assertThat(increasedPosition).isEqualTo(one);
    }

    @DisplayName("위치의 int 값을 반환한다")
    @Test
    void value() {
        //given
        int value = 4;
        Position position = Position.valueOf(value);

        //when
        int actual = position.value();

        //then
        assertThat(actual).isEqualTo(value);
    }

    @Test
    void equality() {
        //given
        int value = 1;
        int other = -1;

        //when
        Position position = Position.valueOf(value);
        Position same = Position.valueOf(value);
        Position different = Position.valueOf(other);

        //then
        assertThat(position)
                .isEqualTo(same).hasSameHashCodeAs(same)
                .isNotEqualTo(different).doesNotHaveSameHashCodeAs(different);
    }
}