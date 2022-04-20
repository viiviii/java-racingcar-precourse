package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    public MoveCondition run() {
        return randomCondition();
    }

    private MoveCondition randomCondition() {
        final int i = Randoms.pickNumberInRange(0, 9);
        return new MoveCondition(i);
    }
}
