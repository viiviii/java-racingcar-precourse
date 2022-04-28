package racingcar.rule;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.race.EnergyFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class EngineTest {
    private EnergyFactory energyFactory = mock(EnergyFactory.class);
    private Engine engine = new Engine(energyFactory);

    @DisplayName("최소 전진 에너지 이상이면 전진한다")
    @Test
    void forwardWhenMoreThan4() {
        //given
        given(energyFactory.get()).willReturn(Engine.FORWARD_ENERGY);

        //when
        Move move = engine.power();

        //then
        assertThat(move.isForward()).isTrue();
    }

    @DisplayName("최소 전진 에너지 미만이면 멈춤이다")
    @Test
    void stopWhenLessThan4() {
        //given
        Energy lessForwardEnergy = Energy.from(Engine.FORWARD_ENERGY.get() - 1);
        given(energyFactory.get()).willReturn(lessForwardEnergy);

        //when
        Move move = engine.power();

        //then
        assertThat(move.isStop()).isTrue();
    }
}
