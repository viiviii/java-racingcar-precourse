package racingcar.gameStrategy;

public final class Car {
    private final EnergyFactory energyFactory;
    private final String name;
    private int position = 0;

    public Car(EnergyFactory energyFactory, String carName) {
        this.energyFactory = energyFactory;
        this.name = carName;
    }

    public String name() {
        return name;
    }

    public int position() {
        return position;
    }

    public int move() {
        final Energy energy = energyFactory.random();
        if (isForward(energy)) {
            increasePosition();
        }
        return position();
    }

    private boolean isForward(Energy energy) {
        final Energy MINIMUM_FORWARD = Energy.valueOf(4);// TODO
        return energy.isMoreThan(MINIMUM_FORWARD);
    }

    private void increasePosition() {
        position += 1;
    }
}
