package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.gameStrategy.Energy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class EnergyTest {

    @DisplayName("0~9 사이의 값만 가능하다")
    @Test
    void validRange() {
        assertDoesNotThrow(() -> Energy.valueOf(0));
        assertDoesNotThrow(() -> Energy.valueOf(9));
    }

    @DisplayName("0~9 사이 값이 아닌 경우 예외가 발생한다")
    @Test
    void thrownExceptionWhenOutsideRange() {
        assertThatIllegalArgumentException().isThrownBy(() -> Energy.valueOf(-1));
        assertThatIllegalArgumentException().isThrownBy(() -> Energy.valueOf(10));
    }

    @DisplayName("2가 어떤 값 이상인지")
    @Test
    void isMoreThan() {
        //given
        Energy one = Energy.valueOf(1);
        Energy two = Energy.valueOf(2);
        Energy three = Energy.valueOf(3);

        //when, then
        assertThat(two.isMoreThan(one)).isTrue();
        assertThat(two.isMoreThan(two)).isTrue();
        assertThat(two.isMoreThan(three)).isFalse();
    }

    @DisplayName("2가 어떤 값 미만인지")
    @Test
    void isLessThan() {
        //given
        Energy one = Energy.valueOf(1);
        Energy two = Energy.valueOf(2);
        Energy three = Energy.valueOf(3);

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
        Energy energy = Energy.valueOf(sameNumber);
        Energy same = Energy.valueOf(sameNumber);
        Energy different = Energy.valueOf(otherNumber);

        //then
        assertThat(energy)
                .isEqualTo(same).hasSameHashCodeAs(same)
                .isNotEqualTo(different).doesNotHaveSameHashCodeAs(different);
    }
}
