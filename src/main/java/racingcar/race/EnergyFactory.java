package racingcar.race;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.rule.Energy;

public class EnergyFactory {

    public Energy get() {
        final int random = Randoms.pickNumberInRange(Energy.MIN, Energy.MAX);
        return Energy.from(random);
    }
}
