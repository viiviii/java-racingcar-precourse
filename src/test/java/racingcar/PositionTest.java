package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    void add() {
        //given
        Position zero = Position.zero;
        Position three = new Position(3);

        //when
        Position added = zero.add(three);

        //then
        assertThat(added.toInt()).isEqualTo(3);
    }

    @Test
    void equality() {
        //given
        int value = 1;
        int other = 2;

        //when
        Position position = new Position(value);
        Position same = new Position(value);
        Position different = new Position(other);

        //then
        assertThat(position)
                .isEqualTo(same).hasSameHashCodeAs(same)
                .isNotEqualTo(different).doesNotHaveSameHashCodeAs(different);
    }
}