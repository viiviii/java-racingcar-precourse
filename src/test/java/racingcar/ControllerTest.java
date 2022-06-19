package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ControllerTest {
    private final Car car = mock(Car.class);
    private final Controlelr controller;

    @DisplayName("1대의 자동차가 1번 움직인다")
    @Test
    void start() throws Exception {
        //given
        BDDMockito.given(car.move()).willReturn(true);

        //when
        controller.start();

        //then
        verify(car).move();
    }
}
