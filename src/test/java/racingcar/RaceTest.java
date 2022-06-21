package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
        given(myRandom.pickNumberInRage(anyInt(), anyInt())).willReturn(FORWARD);

        //when
        Car car1 = new CarImpl("pobi");
        Car car2 = new CarImpl("woni");
        Race race = new Race(Arrays.asList(car1, car2), myRandom); // TODO
        RaceResult result = race.movesBy(moveTimes);

        //then
        assertThat(result.moveTimes()).isEqualTo(moveTimes);
//        assertThat(result.toList()).containsExactly(0, 1, 2);  // TODO
        assertThat(result.toList().get(0).carNames()).containsExactly("pobi", "woni");  // TODO
        assertThat(result.toList().get(0).positionBy("pobi")).isOne();  // TODO
        assertThat(result.toList().get(1).positionBy("pobi")).isEqualTo(2);  // TODO
    }
}
