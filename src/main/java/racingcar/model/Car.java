package racingcar.model;

public class Car {
    private final Position position = Position.fromZero();
    private final Engine engine;

    private final CarName carName;

    public Car(Engine engine, CarName carName) {
        this.engine = engine;
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
