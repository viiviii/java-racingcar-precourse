package racingcar.gameStrategy;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.gameStrategy.Movement.FORWARD;
import static racingcar.gameStrategy.Movement.STOP;

final class MovementStrategyRandom implements MovementStrategy {

    @Override
    public Movement movement() {
        final int randomNumber = pickSingleDigitNumber();
        return toMovement(randomNumber);
    }

    private int pickSingleDigitNumber() {
        final int START = 0;
        final int END = 9;
        return Randoms.pickNumberInRange(START, END);
    }

    private Movement toMovement(int randomNumber) {
        final int MINIMUM_FORWARD_NUMBER = 4;
        return randomNumber >= MINIMUM_FORWARD_NUMBER ? FORWARD : STOP;
    }
}
