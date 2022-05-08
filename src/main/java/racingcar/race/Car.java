package racingcar.race;

import racingcar.rule.Engine;
import racingcar.rule.Move;
import racingcar.rule.Name;
import racingcar.rule.Position;

public class Car {
    private final Engine engine;
    private final Name name;
    private Position position;

    private Car(Engine engine, Position position, Name name) {
        this.engine = engine;
        this.position = position;
        this.name = name;
    }

    static Car of(Engine engine, Position position, Name name) {
        return new Car(engine, position, name);
    }

    static Car of(Engine engine, Position position, String name) {
        final Name carName = new Name(name);
        return new Car(engine, position, carName);
    }

    Name name() {
        return name;
    }

    Position move() {
        final Move move = engine.power();
        if (move.isForward()) {
            position = increasePosition();
        }
        return position;
    }

    private Position increasePosition() {
        final int current = position.get();
        return new Position(current + 1);
    }
}
