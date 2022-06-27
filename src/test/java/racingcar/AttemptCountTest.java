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
        int count = 2;
        Record firstRecord = new StubRecord("pobi", 1);
        Record lastRecord = new StubRecord("pobi", 2);
        given(cars.move()).willReturn(firstRecord, lastRecord);

        //when
        Result result = new AttemptCount(count).move(cars);

        //then
        assertThat(result.attemptCount()).isEqualTo(count);
        assertThat(result.firstRecord()).isEqualTo(firstRecord);
        assertThat(result.lastRecord()).isEqualTo(lastRecord);
        assertThat(result.allRecords()).containsOnlyOnce(firstRecord, lastRecord);
    }

    private static final class StubRecord implements Record {
        private final String carName;
        private final int position;

        private StubRecord(String carName, int position) {
            this.carName = carName;
            this.position = position;
        }

        @Override
        public Iterable<String> carNames() {
            return Arrays.asList(carName);
        }

        @Override
        public int positionBy(String carName) {
            return position;
        }
    }
}