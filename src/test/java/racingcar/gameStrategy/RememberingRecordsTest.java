package racingcar.gameStrategy;

import org.junit.jupiter.api.Test;
import racingcar.gamePlay.Movement;

import static org.assertj.core.api.Assertions.assertThat;

class RememberingRecordsTest {

    @Test
    void save() {
        //given
        String carName = "pobi";
        Movement firstMovement = Movement.FORWARD;
        Movement secondsMovement = Movement.STOP;

        //when
        RememberingRecords records = new RememberingRecords();
        records.save(carName, firstMovement);
        records.save(carName, secondsMovement);

        //then
        assertThat(records.recordOf(carName))
                .containsExactly(firstMovement, secondsMovement);
    }
}