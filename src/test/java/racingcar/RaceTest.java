package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class RaceTest {
    private final MyRandom myRandom = mock(MyRandom.class);
    private final int STOP = 3;
    private final int FORWARD = 4;

    @DisplayName("자동차가 여러번 움직인다")
    @Test
    void moves() {
        //given
        int moveTimes = 3;
        given(myRandom.pickNumberInRage(anyInt(), anyInt())).willReturn(STOP, FORWARD, FORWARD);

        //when
        Car car = new CarImpl();
        Race race = new Race(car, myRandom);
        RaceResult result = race.movesBy(moveTimes);

        //then
        assertThat(result.moveTimes()).isEqualTo(moveTimes);
        assertThat(result.toList()).containsExactly(0, 1, 2);  // TODO
    }
}
