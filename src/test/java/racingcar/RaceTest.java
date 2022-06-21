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

    @DisplayName("자동차가 여러번 움직인다")
    @Test
    void moves() throws Exception {
        //given
        int moveTimes = 2;
        given(myRandom.pickNumberInRage(anyInt(), anyInt())).willReturn(4);

        //when
        Car car = new CarImpl();
        Race race = new Race(car, myRandom);
        List<Boolean> moved = race.movesBy(moveTimes);

        //then
        assertThat(moved).hasSize(moveTimes);
        assertThat(moved).containsExactly(true, true);
    }
}
