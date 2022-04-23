package racingcar.model.car;

import racingcar.model.Energy;

public class Car {
    private final Engine engine = new Engine();
    private final Position position = Position.init();

    private final Name name;

    public Car(String name) {
        this.name = new Name(name);
    }

    // TODO: Position 리턴하는게 자연스럽지 않나?
    public CarResult moveBy(Energy energy) {
        final Move move = engine.powerBy(energy);
        if (move.isForward()) {
            position.increase();
        }
        return createResult();
    }

    private CarResult createResult() {
        return new CarResult(name, Position.copyOf(position));
    }
}
