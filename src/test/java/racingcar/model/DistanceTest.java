package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class DistanceTest {

    @DisplayName("거리는 -로 나타낸다")
    @ParameterizedTest
    @CsvSource(value = {"0, ''", "1, -", "2, --", "3, ---"})
    void distance(int count, String expected) {
        //given
        Position position = Position.from(count);
        //when
        String actual = Distance.from(position);

        //then
        assertThat(actual).isEqualTo(expected);
    }
}
