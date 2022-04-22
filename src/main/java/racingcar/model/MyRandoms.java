package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class MyRandoms {

    public MyRandoms() {
    }

    public int value() {
        final int START_RANGE = 0;
        final int END_RANGE = 9;
        return Randoms.pickNumberInRange(START_RANGE, END_RANGE); // TODO
    }
}
