package racingcar.model;

public class Car {
    private final Position position = Position.fromZero();

    private final Engine engine;
    private final CarName carName;
    private final MyRandoms myRandoms; // TODO: 임시

    public Car(Engine engine, MyRandoms myRandoms, CarName carName) {
        this.engine = engine;
        this.myRandoms = myRandoms;
        this.carName = carName;
    }

    public MoveResult move() {
        moveAtRandom();
        return createMoveResult();
    }

    private void moveAtRandom() {
        final int randomEnergy = myRandoms.value();
        final Move move = engine.powerBy(randomEnergy);
        if (move.isForward()) {
            moveForward();
        }
    }

    private void moveForward() {
        position.increase();
    }

    private MoveResult createMoveResult() {
        // TODO: 새로운 객체 리턴 vs increase 메서드 package-private vs MoveResult에 원시형으로 할당?
        final Position currentPosition = Position.from(position.get());
        return new MoveResult(carName, currentPosition);
    }
}
