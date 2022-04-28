package racingcar.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.rule.Name;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarFactoryTest {

    @DisplayName("입력받은 이름들로 자동차 목록을 만든다")
    @Test
    void factory() {
        //given
        List<Name> names = Arrays.asList(new Name("pobi"));

        //when
        CarFactory carFactory = CarFactory.fromDefault();
        List<Car> cars = carFactory.create(names);

        //then
        assertThat(cars).hasSize(1);
    }
}