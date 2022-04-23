package racingcar.model.car;

import racingcar.model.Energy;

public class Car {
    private final Engine engine = new Engine();
    private final Position position = Position.init();

    private final Name name;

    public Car(String name) {
        this.name = new Name(name);
    }

    public CarResult moveBy(Energy energy) {
        final Move move = engine.powerBy(energy);
        if (move.isForward()) {
            position.increase();
        }
        return createResult();
    }

    private CarResult createResult() {
        // TODO: 새로운 객체 리턴 vs increase 메서드 package-private vs CarResult에 원시형으로 할당?
        return new CarResult(name, Position.copyOf(position));
    }
}
