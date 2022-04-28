package racingcar.race;

import racingcar.rule.Energy;

public class EnergyFactory {

    public Energy get() {
        return Energy.atRandom(); // TODO
    }
}
