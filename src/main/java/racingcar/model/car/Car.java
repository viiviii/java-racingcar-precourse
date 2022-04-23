package racingcar.model.car;

import racingcar.model.Energy;
import racingcar.model.MoveResult;

public class Car {
    private final Engine engine = new Engine();
    private final Position position = Position.fromZero();

    private final CarName carName;

    public Car(CarName carName) {
        this.carName = carName;
    }

    public MoveResult moveBy(Energy energy) {
        final Move move = engine.powerBy(energy);
        if (move.isForward()) {
            position.increase();
        }
        return createMoveResult();
    }

    private MoveResult createMoveResult() {
        // TODO: 새로운 객체 리턴 vs increase 메서드 package-private vs MoveResult에 원시형으로 할당?
        final Position currentPosition = Position.from(position.get());
        return new MoveResult(carName, currentPosition);
    }
}
