package racingcar.race;

import racingcar.rule.*;

public class Car {
    private final Engine engine;
    private final Position position;
    private final Name name;

    private Car(Engine engine, Position position, Name name) {
        this.engine = engine;
        this.position = position;
        this.name = name;
    }

    static Car of(Engine engine, Position position, String name) {
        final Name carName = new Name(name);
        return new Car(engine, position, carName);
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
