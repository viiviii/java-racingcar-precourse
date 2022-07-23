package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.gameStrategy.MovementNumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class MovementNumberTest {

    @DisplayName("0~9 사이의 값만 가능하다")
    @Test
    void validRange() {
        assertDoesNotThrow(() -> MovementNumber.valueOf(0));
        assertDoesNotThrow(() -> MovementNumber.valueOf(9));
    }

    @DisplayName("0~9 사이 값이 아닌 경우 예외가 발생한다")
    @Test
    void thrownExceptionWhenOutsideRange() {
        assertThatIllegalArgumentException().isThrownBy(() -> MovementNumber.valueOf(-1));
        assertThatIllegalArgumentException().isThrownBy(() -> MovementNumber.valueOf(10));
    }

    @DisplayName("2가 어떤 값 이상인지")
    @Test
    void isMoreThan() {
        //given
        MovementNumber one = MovementNumber.valueOf(1);
        MovementNumber two = MovementNumber.valueOf(2);
        MovementNumber three = MovementNumber.valueOf(3);

        //when, then
        assertThat(two.isMoreThan(one)).isTrue();
        assertThat(two.isMoreThan(two)).isTrue();
        assertThat(two.isMoreThan(three)).isFalse();
    }

    @DisplayName("2가 어떤 값 미만인지")
    @Test
    void isLessThan() {
        //given
        MovementNumber one = MovementNumber.valueOf(1);
        MovementNumber two = MovementNumber.valueOf(2);
        MovementNumber three = MovementNumber.valueOf(3);

        //when, then
        assertThat(two.isLessThan(one)).isFalse();
        assertThat(two.isLessThan(two)).isFalse();
        assertThat(two.isLessThan(three)).isTrue();
    }

    @Test
    void equality() {
        //given
        int sameNumber = 1;
        int otherNumber = 2;

        //when
        MovementNumber movementNumber = MovementNumber.valueOf(sameNumber);
        MovementNumber same = MovementNumber.valueOf(sameNumber);
        MovementNumber different = MovementNumber.valueOf(otherNumber);

        //then
        assertThat(movementNumber)
                .isEqualTo(same).hasSameHashCodeAs(same)
                .isNotEqualTo(different).doesNotHaveSameHashCodeAs(different);
    }
}
