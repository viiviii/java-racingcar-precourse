package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        int moveTimes = 5;
        given(myRandom.pickNumberInRage(anyInt(), anyInt())).willReturn(FORWARD, STOP, FORWARD);

        //when
        Car car = new CarImpl();
        Race race = new Race(car, myRandom);
        List<Integer> positions = race.movesBy(moveTimes);

        //then
        assertThat(positions)
                .hasSize(moveTimes)
                .containsExactly(1, 1, 2, 3, 4);
    }
}
