package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.gamePlay.AttemptCount;
import racingcar.gamePlay.Cars;
import racingcar.gamePlay.RaceResult;
import racingcar.gamePlay.Record;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class AttemptCountTest {

    private final Cars cars = mock(Cars.class);

    @DisplayName("이동 횟수 만큼 자동차들이 이동한다")
    @Test
    void moveCars() {
        //given
        int count = 5;

        //when
        new AttemptCount(count).move(cars);

        //then
        verify(cars, times(count)).move();
    }

    @DisplayName("자동차들의 이동 기록 목록을 리턴한다")
    @Test
    void result() {
        //given
        int count = 1;
        StubRecord record = new StubRecord();
        given(cars.move()).willReturn(record);

        //when
        RaceResult result = new AttemptCount(count).move(cars);

        //then
        assertThat(result.attemptCount()).isEqualTo(count);
        assertThat(result.recordOf(0)).isEqualTo(record); // TODO: index 0, count 1이 이상함
    }

    private static final class StubRecord implements Record {
        @Override
        public Set<String> carNames() {
            return new HashSet<>(Arrays.asList("pobi"));
        }

        @Override
        public int positionBy(String carName) {
            return 1;
        }
    }
}