package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ControllerTest {
    private final Car car = mock(Car.class);
    private final View view = mock(View.class);
    private final MyRandom myRandom = mock(MyRandom.class);
    private final Controller controller = new Controller(view, car, myRandom);

    @DisplayName("1대의 자동차가 1번 움직인다")
    @Test
    void start() {
        //given
        int forward = 4;
        boolean moved = true;
        given(myRandom.pickNumberInRage(anyInt(), anyInt())).willReturn(forward);
        given(car.move(forward)).willReturn(moved);

        //when
        controller.start();

        //then
        verify(car).move(forward);
        verify(view).moveResult(moved);
    }

    public static final class Controller {
        private final View view;
        private final Car car;
        private final MyRandom myRandom;

        public Controller(View view, Car car, MyRandom myRandom) {
            this.view = view;
            this.car = car;
            this.myRandom = myRandom;
        }

        public void start() {
            int conditions = myRandom.pickNumberInRage(0, 9);
            boolean moved = car.move(conditions);
            view.moveResult(moved);
        }
    }

    public interface Car {
        boolean move(int number);
    }

    public interface View {
        void moveResult(boolean moved);
    }

    public class MyRandom {
        public int pickNumberInRage(int startInclusive, int endInclusive) {
            return Randoms.pickNumberInRange(startInclusive, endInclusive);
        }
    }
}
