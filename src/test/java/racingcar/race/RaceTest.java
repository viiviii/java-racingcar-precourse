package racingcar.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.rule.MoveCount;
import racingcar.rule.Position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.*;

class RaceTest {
    private CarFactory carFactory = CarFactory.fromDefault();
    private Position position = new Position(1);
    private Position winnerPosition = new Position(3);

    @DisplayName("우승자가 한 명일 때")
    @Test
    void winner() {
        //given
        Car car1 = carFactory.of(position, "pobi");
        Car car2 = carFactory.of(winnerPosition, "crong");
        Car car3 = carFactory.of(position, "honux");
        Race race = Race.from(car1, car2, car3);

        //when
        WinnersDto actual = race.getWinners();

        //then
        assertThat(actual.get()).containsOnly("crong");
    }

    @DisplayName("우승자가 여러 명일 때")
    @Test
    void winners() {
        //given
        Car car1 = carFactory.of(position, "pobi");
        Car car2 = carFactory.of(winnerPosition, "crong");
        Car car3 = carFactory.of(winnerPosition, "honux");
        Race race = Race.from(car1, car2, car3);

        //when
        WinnersDto actual = race.getWinners();

        //then
        assertThat(actual.get()).containsOnly("crong", "honux");
    }

    @DisplayName("이동 횟수만큼 자동차가 움직인다")
    @Test
    void startRaceWith() {
        //given
        Car car = mock(Car.class);
        MoveCount moveCount = MoveCount.fromString("5");

        //when
        Race.from(car).startWith(moveCount);

        //then
        verify(car, times(moveCount.get())).move();
    }


    @DisplayName("빈 목록인 경우 예외가 발생한다")
    @Test
    void throwExceptionWhenEmpty() {
        //given
        List<Car> empty = Collections.emptyList();

        //when
        Throwable thrown = catchThrowable(() -> Race.from(empty));

        //then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경주할 자동차는 1대 이상이어야 한다.");
    }

    @DisplayName("경주할 자동차는 최대 10대까지 가능하다")
    @Test
    void thrownExceptionWhenMaxCars() {
        //given
        int GRATER_THAN_CAR_LIST_SIZE = 10 + 1;
        List<Car> cars = createCarAs(GRATER_THAN_CAR_LIST_SIZE);

        //when
        Throwable thrown = catchThrowable(() -> Race.from(cars));

        //then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경주할 자동차는 10대 이하여야 한다.");
    }

    // TODO
    private List<Car> createCarAs(int index) {
        final Position position = Position.start();
        final List<Car> cars = new ArrayList<>();
        for (int i = 0; i < index; i++) {
            final String carName = String.format("car%d", i);
            cars.add(carFactory.of(position, carName));
        }
        return cars;
    }
}
