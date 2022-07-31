package racingcar.gameStrategy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.gamePlay.Movement.FORWARD;
import static racingcar.gamePlay.Movement.STOP;

class MovementTest {

    @Test
    void isForward() {
        assertThat(FORWARD.isForward()).isTrue();
        assertThat(STOP.isForward()).isFalse();
    }

    @Test
    void isStop() {
        assertThat(FORWARD.isStop()).isFalse();
        assertThat(STOP.isStop()).isTrue();
    }
}