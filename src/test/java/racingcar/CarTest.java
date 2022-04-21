package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.MockedStatic;
import org.mockito.stubbing.OngoingStubbing;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import static racingcar.MoveCondition.*;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @DisplayName("자동차는 전진할 수 있다")
    @Test
    void forward() throws Throwable {
        mockingRandomsPickNumberInRange(
                whenUsing -> whenUsing.thenReturn(MIN_FORWARD_CONDITION),
                () -> {
                    // given
                    MoveCondition moveCondition = car.move();

                    //when
                    boolean actual = moveCondition.isForward();

                    //then
                    assertThat(actual).isTrue();
                });
    }

    @DisplayName("자동차는 멈출 수 있다")
    @Test
    void stop() throws Throwable {
        mockingRandomsPickNumberInRange(
                whenUsing -> whenUsing.thenReturn(MAX_STOP_CONDITION),
                () -> {
                    // given
                    MoveCondition moveCondition = car.move();

                    //when
                    boolean actual = moveCondition.isStop();

                    //then
                    assertThat(actual).isTrue();
                });
    }

    private void mockingRandomsPickNumberInRange(
            Function<OngoingStubbing<Integer>, OngoingStubbing<Integer>> thenReturn,
            Executable executable
    ) throws Throwable {
        try (final MockedStatic<Randoms> mocked = mockStatic(Randoms.class)) {
            thenReturn.apply(mocked.when(() -> Randoms.pickNumberInRange(START_RANGE, END_RANGE)));
            executable.execute();
        }
    }
}
