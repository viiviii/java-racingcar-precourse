package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.gamePlay.AttemptCount;
import racingcar.gamePlay.Cars;
import racingcar.gamePlay.Record;
import racingcar.gamePlay.Result;

import java.util.Arrays;

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
        Result result = new AttemptCount(count).move(cars);

        //then
        assertThat(result.attemptCount()).isEqualTo(count);
        assertThat(result.allRecords()).containsOnlyOnce(record);
    }

    private static final class StubRecord implements Record {
        @Override
        public Iterable<String> carNames() {
            return Arrays.asList("pobi");
        }

        @Override
        public int positionBy(String carName) {
            return 1;
        }
    }
}