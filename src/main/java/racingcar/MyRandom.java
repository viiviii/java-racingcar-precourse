package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public final class MyRandom {
    public int pickNumberInRage(int startInclusive, int endInclusive) {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
