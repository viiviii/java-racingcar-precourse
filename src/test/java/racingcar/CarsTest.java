package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @DisplayName("쉼표로 구분된 문자열로 자동차들을 만든다")
    @ParameterizedTest
    @CsvSource(value = {
            "pobi==1",
            "pobi,crong==2",
            "pobi,crong,honux==3"
    }, delimiterString = "==")
    void create(String names, int expectedCarsCount) {
        //when
        Cars cars = Cars.fromString(names);

        //then
        assertThat(cars.count()).isEqualTo(expectedCarsCount);
    }
}
