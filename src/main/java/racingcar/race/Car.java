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

    static Car of(String name, Position position) {
        final Name carName = new Name(name);
        return new Car(carName, position);
    }

    Name name() {
        return name;
    }

    Position position() {
        return position;
    }

    int comparePositionTo(Car car) {
        return this.position.compareTo(car.position);
    }

    boolean inPosition(Position other) {
        return this.position.equals(other);
    }

    Position moveBy(Energy energy) {
        final Move move = engine.powerBy(energy);
        if (move.isForward()) {
            position.increase();
        }
        return position.copy();
    }
}
