package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.model.MoveCount;
import racingcar.model.car.CarResult;

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

    // TODO
    @DisplayName("자동차들이 달린다")
    @Test
    void move() {
        //given
        MoveCount moveCount = MoveCount.fromString("5");
        Cars cars = Cars.fromString("pobi,crong,honux");

        //when
        List<List<CarResult>> result = cars.move(moveCount);
        int actualMoveCount = result.size();
        int actualCarsCount = result.get(0).size();

        //then
        assertThat(actualMoveCount).isEqualTo(moveCount.get());
        assertThat(actualCarsCount).isEqualTo(3);
    }
}
