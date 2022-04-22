package racingcar.model;

public class Car {
    private final CarName carName;
    private final MyRandoms myRandoms; // TODO: 임시
    private final MoveCondition condition; // TODO: 임시
    private final Position position = Position.fromZero();

    public Car(MyRandoms myRandoms, CarName carName, MoveCondition condition) {
        this.myRandoms = myRandoms;
        this.carName = carName;
        this.condition = condition;
    }

    public MoveResult move() {
        moveAtRandom();
        return createMoveResult();
    }

    private void moveAtRandom() {
        // TODO: moveCondition.isForWard()가 어딘가 이상함. 움직임 결과가 전진이면도 아니고 움직임 조건이 전진이면?이상함
        final int random = myRandoms.value();
        final Move move = condition.checkBy(random);
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
