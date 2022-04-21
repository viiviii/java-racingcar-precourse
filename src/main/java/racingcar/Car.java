package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.MoveCondition.*;

public class Car {

    private int forwardCount = 0;

    public CarResult move() {
        MoveCondition moveCondition = randomCondition();
        if(moveCondition.isForward()) {
            forwardCount += 1;
        }
        return new CarResult(forwardCount);
    }

    private MoveCondition randomCondition() {
        final int i = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
        return new MoveCondition(i);
    }
}
