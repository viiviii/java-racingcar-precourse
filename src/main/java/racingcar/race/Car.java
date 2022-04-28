package racingcar.race;

import racingcar.rule.Engine;
import racingcar.rule.Move;
import racingcar.rule.Name;
import racingcar.rule.Position;

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

    Position move() {
        final Move move = engine.power();
        if (move.isForward()) {
            position.increase();
        }
        return position.copy();
    }
}
