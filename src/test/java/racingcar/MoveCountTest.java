package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class MoveCountTest {

    @DisplayName("숫자 문자열로 생성할 수 있다")
    @Test
    void createMoveCountFromString() {
        //given
        String count = "5";

        //when
        Throwable thrown = catchThrowable(() -> MoveCount.fromString(count));

        //then
        assertThat(thrown).doesNotThrowAnyException();
    }

    @DisplayName("숫자 문자열로 생성할 수 없으면 예외가 발생한다")
    @Test
    void throwExceptionWhenCannotParsingByNumbers() {
        //given
        String invalidCount = "a5";

        //when
        Throwable thrown = catchThrowable(() -> MoveCount.fromString(invalidCount));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
