package racingcar.race;

import racingcar.rule.*;

class Car {
    private final Engine engine = new Engine();
    private final Name name;
    private final Position position;

    private Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    static Car of(String name, int position) {
        final Name carName = new Name(name);
        final Position carPosition = new Position(position);
        return new Car(carName, carPosition);
    }

    static Car inStartingPositionWith(String name) {
        final Name carName = new Name(name);
        final Position carPosition = Position.init();
        return new Car(carName, carPosition);
    }

    String name() {
        return name.get();
    }

    int position() {
        return position.get();
    }

    int compareToPosition(Car car) {
        return this.position.compareTo(car.position);
    }

    boolean inPosition(int other) {
        return this.position.equals(new Position(other));
    }

    int moveBy(Energy energy) {
        final Move move = engine.powerBy(energy);
        if (move.isForward()) {
            position.increase();
        }
        return position();
    }
}
