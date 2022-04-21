package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.MoveCondition.*;

public class Car {

    public MoveCondition move() {
        return randomCondition();
    }

    private MoveCondition randomCondition() {
        final int i = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
        return new MoveCondition(i);
    }
}
