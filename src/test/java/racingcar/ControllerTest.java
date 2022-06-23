package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import racingcar.gamePlay.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class ControllerTest {
    private final List<String> carNames = Arrays.asList("pobi", "woni");

    private final View view = mock(View.class);
    private final CarFactory carFactory = mock(CarFactory.class);
    private final Controller controller = new Controller(view, carFactory);

    @DisplayName("자동차 이름과 이동 횟수를 입력받은 후 실행 결과를 출력한다")
    @Test
    void start() {
        //given
        int attemptCount = 2;

        given(view.inputCarNames()).willReturn(carNames);
        given(view.inputAttemptCount()).willReturn(attemptCount);
        given(carFactory.createCars(carNames)).willReturn(new StubCars());
        InOrder inOrder = inOrder(view, carFactory);

        //when
        controller.start();

        //then
        inOrder.verify(view).inputCarNames();
        inOrder.verify(carFactory).createCars(carNames);
        inOrder.verify(view).inputAttemptCount();
        inOrder.verify(view).raceResult(any(RaceResult.class));
    }

    private final class StubCars implements Cars {
        @Override
        public Record move() {
            return new StubRecord();
        }
    }

    private final class StubRecord implements Record {
        @Override
        public Set<String> carNames() {
            return new HashSet<>(carNames);
        }

        @Override
        public int positionBy(String carName) {
            return 0;
        }
    }
}
