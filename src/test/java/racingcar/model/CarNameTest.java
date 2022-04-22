package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNameTest {

    @DisplayName("자동차 이름은 5자 이하만 가능하다")
    @Test
    void should5LengthOrLess() {
        //given
        String fiveLength = "apple";

        //when
        Throwable thrown = catchThrowable(() -> new CarName(fiveLength));

        //then
        assertThat(thrown).doesNotThrowAnyException();
    }

    @DisplayName("자동차 이름이 5글자를 초과하면 예외가 발생한다")
    @Test
    void throwExceptionWhenLengthMoreThan5() {
        //given
        String sixLength = "banana";

        //when
        Throwable thrown = catchThrowable(() -> new CarName(sixLength));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
