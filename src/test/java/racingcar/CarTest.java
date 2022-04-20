package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    
    @DisplayName("자동차는 전진할 수 있다")
    @Test
    void move() {
        //given
        Car car = new Car();

        //when

        MoveCondition condition = car.run();
    
        //then
        assertThat(condition.isMove()).isTrue();
    }

    @DisplayName("자동차는 멈출 수 있다")
    @Test
    void stop() {
        //given
        Car car = new Car();

        //when
        MoveCondition condition = car.run();

        //then
        assertThat(condition.isStop()).isTrue();
    }
}
