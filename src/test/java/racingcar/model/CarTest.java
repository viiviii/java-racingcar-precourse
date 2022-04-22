package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;
import static racingcar.model.MoveCondition.END_RANGE;
import static racingcar.model.MoveCondition.MAX_STOP_CONDITION;
import static racingcar.model.MoveCondition.MIN_FORWARD_CONDITION;
import static racingcar.model.MoveCondition.START_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.function.Function;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.MockedStatic;
import org.mockito.stubbing.OngoingStubbing;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        CarName carName = new CarName("apple");
        car = new Car(carName);
    }

    @DisplayName("자동차는 1회 전진했다")
    @Test
    void forwardOnce() throws Throwable {
        mockingRandomsPickNumberInRange(
                whenUsing -> whenUsing.thenReturn(MIN_FORWARD_CONDITION),
                () -> {
                    // given
                    MoveResult result = car.move();

                    //when
                    Position actual = result.position();

                    //then
                    assertThat(actual.get()).isOne();
                });
    }

    @DisplayName("자동차는 1회 멈춰있다")
    @Test
    void stopOnce() throws Throwable {
        mockingRandomsPickNumberInRange(
                whenUsing -> whenUsing.thenReturn(MAX_STOP_CONDITION),
                () -> {
                    // given
                    MoveResult result = car.move();

                    //when
                    Position actual = result.position();

                    //then
                    assertThat(actual.get()).isZero();
                });
    }

    @DisplayName("자동차가 2회 전진했다")
    @Test
    void forwardTwice() throws Throwable {
        mockingRandomsPickNumberInRange(
                whenUsing -> whenUsing.thenReturn(MIN_FORWARD_CONDITION, MIN_FORWARD_CONDITION),
                () -> {
                    // given
                    MoveResult firstResult = car.move();
                    MoveResult secondResult = car.move();

                    //when
                    Position firstPosition = firstResult.position();
                    Position secondsPosition = secondResult.position();

                    //then
                    assertThat(firstPosition.get()).isEqualTo(1);
                    assertThat(secondsPosition.get()).isEqualTo(2);
                });
    }

    @DisplayName("자동차가 2회 멈춰있다")
    @Test
    void stopTwice() throws Throwable {
        mockingRandomsPickNumberInRange(
                whenUsing -> whenUsing.thenReturn(MAX_STOP_CONDITION, MAX_STOP_CONDITION),
                () -> {
                    //given
                    MoveResult firstResult = car.move();
                    MoveResult secondResult = car.move();

                    //when
                    Position firstPosition = firstResult.position();
                    Position secondsPosition = secondResult.position();

                    //then
                    assertThat(firstPosition.get()).isZero();
                    assertThat(secondsPosition.get()).isZero();
                });
    }

    @DisplayName("자동차가 1회 전진하고 1회 멈춰있다")
    @Test
    void forwardAndStop() throws Throwable {
        mockingRandomsPickNumberInRange(
                whenUsing -> whenUsing.thenReturn(MIN_FORWARD_CONDITION, MAX_STOP_CONDITION),
                () -> {
                    // given
                    MoveResult firstResult = car.move();
                    MoveResult secondResult = car.move();

                    //when
                    Position firstPosition = firstResult.position();
                    Position secondsPosition = secondResult.position();

                    //then
                    assertThat(firstPosition.get()).isOne();
                    assertThat(secondsPosition.get()).isOne();
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
