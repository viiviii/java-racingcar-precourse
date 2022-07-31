package racingcar.gameStrategy;

import org.junit.jupiter.api.Test;
import racingcar.gamePlay.Movement;

import static org.assertj.core.api.Assertions.assertThat;

class RememberingStateTest {

    @Test
    void save() {
        //given
        RememberingState state = new RememberingState();

        //when
        state.save(Movement.FORWARD);
        state.save(Movement.FORWARD);

        //then
        assertThat(state.forwardCount()).isEqualTo(2);
    }
}