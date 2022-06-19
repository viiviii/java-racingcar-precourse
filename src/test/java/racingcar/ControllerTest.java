package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ControllerTest {
    private final Car car = mock(Car.class);
    private final View view = mock(View.class);
    private final Controller controller = new Controller(view, car);

    @DisplayName("1대의 자동차가 1번 움직인다")
    @Test
    void start() {
        //given
        given(car.move()).willReturn(true);

        //when
        controller.start();

        //then
        verify(car).move();
        verify(view).moveResult(anyBoolean());
    }

    public static final class Controller {
        private final View view;
        private final Car car;

        public Controller(View view, Car car) {
            this.view = view;
            this.car = car;
        }

        public void start() {
            boolean moved = car.move();
            view.moveResult(moved);
        }
    }

    public interface Car {
        boolean move();
    }

    public interface View {
        void moveResult(boolean moved);
    }
}
