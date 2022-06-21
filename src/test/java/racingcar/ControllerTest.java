package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
        int moveCount = 2;
        int forward = 4;

        given(view.inputMoveTimes()).willReturn(moveCount);
        given(myRandom.pickNumberInRage(anyInt(), anyInt())).willReturn(forward);

        //when
        controller.start();

        //then
        verify(view).inputMoveTimes();
        verify(myRandom, times(moveCount)).pickNumberInRage(anyInt(), anyInt());
        verify(view).moveResult(Arrays.asList(true, true));
    }
}
