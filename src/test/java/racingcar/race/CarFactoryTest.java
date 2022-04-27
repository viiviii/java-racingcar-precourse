package racingcar.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.rule.Engine;
import racingcar.rule.Position;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarFactoryTest {

    @DisplayName("입력받은 문자열로 자동차를 만든다")
    @Test
    void factory() {
        //given
        Engine engine = new Engine();
        Position position = Position.start();
        String model = "pobi,crong,honux";

        //when
        List<Car> cars = CarFactory.from(engine, position).create(model);

        //then
        assertThat(cars).hasSize(3);
    }
}