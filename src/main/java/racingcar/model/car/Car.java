package racingcar.model.car;

import racingcar.model.Energy;

// TODO: Equals, HashCode 할까말까
public class Car {
    private final Engine engine = new Engine();
    private final Name name;
    private final Position position;

    private Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public static Car of(String name, int position) {
        final Name carName = new Name(name);
        final Position carPosition = new Position(position);
        return new Car(carName, carPosition);
    }

    public static Car inStartingPositionWith(String name) {
        final Name carName = new Name(name);
        final Position carPosition = Position.init();
        return new Car(carName, carPosition);
    }

    public String name() {
        return name.get();
    }

    public int position() {
        return position.get();
    }

    public int compareToPosition(Car car) {
        return this.position.compareTo(car.position);
    }

    public boolean inPosition(int other) {
        return this.position.equals(new Position(other));
    }

    public int moveBy(Energy energy) {
        final Move move = engine.powerBy(energy);
        if (move.isForward()) {
            position.increase();
        }
        return position();
    }
}
