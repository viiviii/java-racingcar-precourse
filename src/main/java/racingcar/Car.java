package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.MoveCondition.END_RANGE;
import static racingcar.MoveCondition.START_RANGE;

public class Car {
    // TODO: 여기 부분도 객체 사용
    private int forwardCount = 0;

    public CarResult move() {
        final MoveCondition moveCondition = randomCondition();
        if (moveCondition.isForward()) {
            forwardCount += 1;
        }
        final ForwardCount currentForwardCount = new ForwardCount(forwardCount);
        return new CarResult(currentForwardCount);
    }

    private MoveCondition randomCondition() {
        final int i = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
        return new MoveCondition(i);
    }
}
