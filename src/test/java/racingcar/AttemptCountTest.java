package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.gamePlay.AttemptCount;
import racingcar.gamePlay.Cars;
import racingcar.gamePlay.RaceResult;
import racingcar.gameStrategy.AttemptCountImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class AttemptCountTest {
    private final Cars cars = mock(Cars.class);

    @DisplayName("이동 횟수 만큼 자동차들이 이동한다")
    @Test
    void moveCars() {
        //given
        int count = 5;

        //when
        AttemptCount attemptCount = new AttemptCountImpl(count);
        RaceResult raceResult = attemptCount.move(cars);

        //then
        assertThat(raceResult.attemptCount()).isEqualTo(count);
    }
}