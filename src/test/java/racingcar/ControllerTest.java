package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class ControllerTest {
    private final Car car = mock(Car.class);
    private final View view = mock(View.class);
    private final MyRandom myRandom = mock(MyRandom.class);
    private final Controller controller = new Controller(view, car, myRandom);

    @DisplayName("1대의 자동차가 2번 움직인다")
    @Test
    void start() {
        //given
        int moveCount = 2;
        int forward = 4;
        boolean moved = true;

        given(view.inputMoveTimes()).willReturn(moveCount);
        given(myRandom.pickNumberInRage(anyInt(), anyInt())).willReturn(forward);
        given(car.move(forward)).willReturn(moved);

        //when
        controller.start();

        //then
        verify(view).inputMoveTimes();
        verify(car, times(moveCount)).move(forward);
        verify(myRandom, times(moveCount)).pickNumberInRage(anyInt(), anyInt());
        verify(view).moveResult(Arrays.asList(true, true));
    }
}
