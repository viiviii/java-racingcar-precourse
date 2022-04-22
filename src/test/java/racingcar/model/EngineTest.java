package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EngineTest {
    private Engine engine = new Engine();

    @DisplayName("4 이상이면 전진이다")
    @Test
    void forwardWhenMoreThan4() {
        //given
        int energy = 4; // TODO: 하드코딩 제거

        //when
        Move move = engine.powerBy(energy);

        //then
        assertThat(move.isForward()).isTrue();
    }

    @DisplayName("4 미만이면 멈춤이다")
    @Test
    void stopWhenLessThan4() {
        //given
        int energy = 4 - 1; // TODO: 하드코딩 제거

        //when
        Move move = engine.powerBy(energy);

        //then
        assertThat(move.isStop()).isTrue();
    }
}
