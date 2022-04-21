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

    @DisplayName("자동차는 1회 전진했다")
    @Test
    void forwardOnce() throws Throwable {
        mockingRandomsPickNumberInRange(
                whenUsing -> whenUsing.thenReturn(MIN_FORWARD_CONDITION),
                () -> {
                    // given
                    CarResult carResult = car.move();

                    //when
                    int actual = carResult.forwardCount();

                    //then
                    assertThat(actual).isOne();
                });
    }

    @DisplayName("자동차는 1회 멈춰있다")
    @Test
    void stopOnce() throws Throwable {
        mockingRandomsPickNumberInRange(
                whenUsing -> whenUsing.thenReturn(MAX_STOP_CONDITION),
                () -> {
                    // given
                    CarResult carResult = car.move();

                    //when
                    int actual = carResult.forwardCount();

                    //then
                    assertThat(actual).isZero();
                });
    }

    @DisplayName("자동차가 2회 전진했다")
    @Test
    void forwardTwice() throws Throwable {
        mockingRandomsPickNumberInRange(
                whenUsing -> whenUsing.thenReturn(MIN_FORWARD_CONDITION, MIN_FORWARD_CONDITION),
                () -> {
                    // given
                    CarResult firstCarResult = car.move();
                    CarResult secondsCarResult = car.move();

                    //when
                    int firstForwardCount = firstCarResult.forwardCount();
                    int secondsForwardCount = secondsCarResult.forwardCount();

                    //then
                    assertThat(firstForwardCount).isEqualTo(1);
                    assertThat(secondsForwardCount).isEqualTo(2);
                });
    }

    @DisplayName("자동차가 2회 멈춰있다")
    @Test
    void stopTwice() throws Throwable {
        mockingRandomsPickNumberInRange(
                whenUsing -> whenUsing.thenReturn(MAX_STOP_CONDITION, MAX_STOP_CONDITION),
                () -> {
                    //given
                    CarResult firstCarResult = car.move();
                    CarResult secondsCarResult = car.move();

                    //when
                    int firstForwardCount = firstCarResult.forwardCount();
                    int secondsForwardCount = secondsCarResult.forwardCount();

                    //then
                    assertThat(firstForwardCount).isZero();
                    assertThat(secondsForwardCount).isZero();
                });
    }

    @DisplayName("자동차가 1회 전진하고 1회 멈춰있다")
    @Test
    void forwardAndStop() throws Throwable {
        mockingRandomsPickNumberInRange(
                whenUsing -> whenUsing.thenReturn(MIN_FORWARD_CONDITION, MAX_STOP_CONDITION),
                () -> {
                    // given
                    CarResult firstCarResult = car.move();
                    CarResult secondsCarResult = car.move();

                    //when
                    int firstForwardCount = firstCarResult.forwardCount();
                    int secondsForwardCount = secondsCarResult.forwardCount();

                    //then
                    assertThat(firstForwardCount).isOne();
                    assertThat(secondsForwardCount).isOne();
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
