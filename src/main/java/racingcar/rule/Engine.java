package racingcar.rule;

import racingcar.race.EnergyFactory;

public class Engine {
    public static final Energy FORWARD_ENERGY = Energy.from(4);
    private final EnergyFactory energyFactory;

    public Engine(EnergyFactory energyFactory) {
        this.energyFactory = energyFactory;
    }

    public Move power() {
        final Energy energy = energyFactory.get();
        if (energy.isLessThan(FORWARD_ENERGY)) {
            return Move.STOP;
        }
        return Move.FORWARD;
    }
}
