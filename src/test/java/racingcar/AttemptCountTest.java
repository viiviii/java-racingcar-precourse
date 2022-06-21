package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class AttemptCountTest {

    private final MyRandom myRandom = mock(MyRandom.class); // TODO
    private final int FORWARD = 4;


    @DisplayName("이동 횟수 만큼 자동차들이 이동한다")
    @Test
    void moveCars() {
        //given
        int count = 5;
        given(myRandom.pickNumberInRage(anyInt(), anyInt())).willReturn(FORWARD); // TODO

        //when
        AttemptCount attemptCount = new AttemptCount(count);
        Cars cars = Cars.of(myRandom, createCar("pobi"));
        RaceResult raceResult = attemptCount.move(cars);

        //then
        assertThat(raceResult.attemptCount()).isEqualTo(count);
    }

    private Car createCar(String carName) {
        return new CarImpl(carName);
    }
}