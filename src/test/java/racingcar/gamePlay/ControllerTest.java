package racingcar.gamePlay;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class ControllerTest {
    private final List<String> carNames = Arrays.asList("pobi", "woni");

    private final View view = mock(View.class);
    private final Cars cars = mock(Cars.class);
    private final CarFactory carFactory = mock(CarFactory.class);
    private final Controller controller = new Controller(view, carFactory);

    @DisplayName("자동차 이름과 이동 횟수를 입력받은 후 실행 결과를 출력한다")
    @Test
    void start() {
        //given
        int attemptCount = 2;

        given(view.inputCarNames()).willReturn(carNames);
        given(view.inputAttemptCount()).willReturn(attemptCount);
        given(carFactory.createCars(carNames)).willReturn(cars);

        //when
        controller.start();

        //then
        verify(view).inputCarNames();
        verify(carFactory).createCars(carNames);
        verify(view).inputAttemptCount();
        verify(cars, times(attemptCount)).move();
        verify(view, times(attemptCount)).outputRecords(any());
    }
}
