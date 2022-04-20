package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class CarTest {
    
    @DisplayName("자동차는 전진할 수 있다")
    @Test
    void move() {
        try(final MockedStatic<Randoms> mocked = mockStatic(Randoms.class)) {
            //given
            Car car = new Car();
            mocked.when(() -> Randoms.pickNumberInRange(0, 9)).thenReturn(4);

            //when
            MoveCondition condition = car.run();

            //then
            assertThat(condition.isMove()).isTrue();
        }
    }

    @DisplayName("자동차는 멈출 수 있다")
    @Test
    void stop() {
        try(final MockedStatic<Randoms> mocked = mockStatic(Randoms.class)) {
            //given
            Car car = new Car();
            mocked.when(() -> Randoms.pickNumberInRange(0, 9)).thenReturn(3);

            //when
            MoveCondition condition = car.run();

            //then
            assertThat(condition.isStop()).isTrue();
        }
    }
}
