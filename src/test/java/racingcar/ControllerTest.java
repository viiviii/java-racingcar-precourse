package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class ControllerTest {
    private final View view = mock(View.class);
    private final MyRandom myRandom = mock(MyRandom.class);
    private final Controller controller = new Controller(view, myRandom);

    @DisplayName("자동차 횟수를 입력받은 후 실행 결과를 출력한다")
    @Test
    void start() {
        //given
        int moveTimes = 2;
        int forward = 4;

        given(view.inputMoveTimes()).willReturn(moveTimes);
        given(myRandom.pickNumberInRage(anyInt(), anyInt())).willReturn(forward);

        //when
        controller.start();

        //then
        verify(view).inputMoveTimes();
        verify(myRandom, times(moveTimes)).pickNumberInRage(anyInt(), anyInt());
        verify(view).raceResult(any());
    }
}
