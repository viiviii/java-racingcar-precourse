package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class EnergyTest {

    @DisplayName("에너지는 0~9 사이의 숫자만 가능하다")
    @Test
    void validRange() {
        //given
        int min = 0;
        int max = 9;

        //when
        Energy minEnergy = new Energy(min);
        Energy maxEnergy = new Energy(max);

        //then
        assertThat(minEnergy.get()).isEqualTo(min); // TODO: 정상 객체 테스트 다른 곳과 일관성 맞추기
        assertThat(maxEnergy.get()).isEqualTo(max);
    }

    @DisplayName("에너지가 0~9 사이의 숫자가 아닌 경우 예외가 발생한다")
    @Test
    void throwExceptionWhenInvalidRange() {
        //given
        int min = 0;
        int max = 9;

        //when
        Throwable lessThanMinThrown = catchThrowable(() -> new Energy(min - 1));
        Throwable overMaxThrown = catchThrowable(() -> new Energy(max + 1));

        //then
        assertThat(lessThanMinThrown).isInstanceOf(IllegalArgumentException.class); // TODO: 명확한 에러 처리
        assertThat(overMaxThrown).isInstanceOf(IllegalArgumentException.class); // TODO: 명확한 에러 처리
    }

}