package racingcar.gameStrategy;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.gameStrategy.Movement.FORWARD;
import static racingcar.gameStrategy.Movement.STOP;

public final class MovementStrategyRandom implements MovementStrategy {

    @Override
    public Movement movement() {
        final int randomNumber = pickNumberInRange();
        return isForwardCondition(randomNumber) ? FORWARD : STOP;
    }
    
    private int pickNumberInRange() {
        final int START = 0;
        final int END = 9;
        return Randoms.pickNumberInRange(START, END);
    }

    private boolean isForwardCondition(int randomNumber) {
        final int MINIMUM_FORWARD_NUMBER = 4;
        return randomNumber >= MINIMUM_FORWARD_NUMBER;
    }
}
