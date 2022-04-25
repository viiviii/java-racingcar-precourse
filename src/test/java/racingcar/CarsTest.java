package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.model.car.Car;

import java.util.List;

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

    @DisplayName("우승자가 한 명일 때")
    @Test
    void winner() {
        //given
        Car car1 = Car.of("pobi", 1);
        Car car2 = Car.of("crong", 3);
        Car car3 = Car.of("honux", 2);
        Cars cars = Cars.from(car1, car2, car3);

        //when
        List<String> actual = cars.getWinner();

        //then
        assertThat(actual).containsOnly("crong");
    }

    @DisplayName("우승자가 여러 명일 때")
    @Test
    void winners() {
        //given
        Car car1 = Car.of("pobi", 3);
        Car car2 = Car.of("crong", 4);
        Car car3 = Car.of("honux", 4);
        Cars cars = Cars.from(car1, car2, car3);

        //when
        List<String> actual = cars.getWinner();

        //then
        assertThat(actual).containsOnly("crong", "honux");
    }
}
