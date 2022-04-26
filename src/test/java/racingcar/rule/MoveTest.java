package racingcar.rule;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoveTest {

    @Test
    void isForward() {
        Move forward = Move.FORWARD;
        assertThat(forward.isForward()).isTrue();
        assertThat(forward.isStop()).isFalse();
    }

    @Test
    void isStop() {
        Move stop = Move.STOP;
        assertThat(stop.isStop()).isTrue();
        assertThat(stop.isForward()).isFalse();
    }
}