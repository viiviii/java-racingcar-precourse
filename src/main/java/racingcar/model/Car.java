package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.model.MoveCondition.END_RANGE;
import static racingcar.model.MoveCondition.START_RANGE;

public class Car {
    private final CarName carName;
    // TODO: 여기 부분도 객체 사용
    private Position position = new Position(0);

    public Car(CarName carName) {
        this.carName = carName;
    }

    public MoveResult move() {
        moveAtRandom();
        return createMoveResult();
    }

    private void moveAtRandom() {
        // TODO: moveCondition.isForWard()가 어딘가 이상함. 움직임 결과가 전진이면도 아니고 움직임 조건이 전진이면?이상함
        final MoveCondition moveCondition = moveConditionAtRandom();
        if (moveCondition.isForward()) {
            moveForward();
        }
    }

    private MoveCondition moveConditionAtRandom() {
        final int i = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
        return new MoveCondition(i);
    }

    private void moveForward() {
        position.increase();
    }

    private MoveResult createMoveResult() {
        // TODO: 새로운 객체 리턴 vs increase 메서드 package-private vs MoveResult에 원시형으로 할당?
        final Position currentPosition = new Position(position.get());
        return new MoveResult(carName, currentPosition);
    }
}
