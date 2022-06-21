package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.util.Arrays;
import java.util.List;

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
        List<String> carNames = Arrays.asList("pobi", "woni");
        int moveTimes = 2;
        int wantedRandomCalls = carNames.size() * moveTimes; // TODO
        int forward = 4;

        given(view.inputCarNames()).willReturn(carNames);
        given(view.inputMoveTimes()).willReturn(moveTimes);
        given(myRandom.pickNumberInRage(anyInt(), anyInt())).willReturn(forward);
        InOrder inOrder = inOrder(view, myRandom);

        //when
        controller.start();

        //then
        inOrder.verify(view).inputCarNames();
        inOrder.verify(view).inputMoveTimes();
        inOrder.verify(myRandom, times(wantedRandomCalls)).pickNumberInRage(anyInt(), anyInt());
        inOrder.verify(view).raceResult(any());
    }
}
