package racingcar.race;

import racingcar.rule.Engine;
import racingcar.rule.Move;
import racingcar.rule.Name;
import racingcar.rule.Position;

public class Car {
    private final Engine engine;
    private final Name name;
    private Position position;

    private Car(Engine engine, Name name, Position position) {
        this.engine = engine;
        this.position = position;
        this.name = name;
    }

    public static Car of(Engine engine, Name name, Position position) {
        return new Car(engine, name, position);
    }

    public Name name() {
        return name;
    }

    public Position move() {
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
