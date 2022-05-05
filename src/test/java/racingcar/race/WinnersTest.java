package racingcar.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.rule.Name;
import racingcar.rule.Position;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    @DisplayName("가장 먼 위치의 자동차가 우승이다")
    @Test
    void winners() {
        //given
        Winners winners = new Winners();
        CarFactory carFactory = CarFactory.fromDefault();
        Car car1 = carFactory.of(new Position(1), "pobi");
        Car car2 = carFactory.of(new Position(9), "crong");
        Car car3 = carFactory.of(new Position(3), "honux");

        //when
        List<Name> winnerNames = winners.determineFrom(Arrays.asList(car1, car2, car3));

        //then
        assertThat(winnerNames).containsOnly(car2.name());
    }
}