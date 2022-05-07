package racingcar.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.rule.Name;
import racingcar.rule.Position;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class RacingCarsTest {

    @DisplayName("경주할 자동차가 없는 경우 예외가 발생한다")
    @Test
    void throwExceptionWhenEmpty() {
        //given
        List<Car> empty = Collections.emptyList();

        //when
        Throwable thrown = catchThrowable(() -> RacingCars.from(empty));

        //then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경주할 자동차는 1대 이상이어야 한다.");
    }

    @DisplayName("경주할 자동차가 최대 값을 초과하는 경우 예외가 발생한다")
    @Test
    void throwExceptionWhenGraterThanMaxSize() {
        //given
        int GRATER_THAN_CAR_LIST_SIZE = 10 + 1;
        List<Car> cars = mock(List.class);
        given(cars.size()).willReturn(GRATER_THAN_CAR_LIST_SIZE);

        //when
        Throwable thrown = catchThrowable(() -> RacingCars.from(cars));

        //then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경주할 자동차는 10대 이하여야 한다.");
    }

    @DisplayName("자동차들이 움직인다")
    @Test
    void move() {
        //given
        Name name = new Name("pobi");
        Position position = new Position(5);
        Car car = mock(Car.class);
        given(car.name()).willReturn(name);
        given(car.move()).willReturn(position);

        //when
        MoveRecords moveRecords = RacingCars.of(car).move();

        //then
        verify(car).move();
        assertThat(moveRecords.positionBy(name)).isEqualTo(position);
    }
}
