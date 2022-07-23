package racingcar.gameStrategy;

import camp.nextstep.edu.missionutils.Randoms;

public final class MovementNumberStrategyRandom implements MovementNumberStrategy {

    @Override
    public MovementNumber get() {
        return MovementNumber.valueOf(randomNumber());
    }

    private int randomNumber() {
        return Randoms.pickNumberInRange(MovementNumber.MIN, MovementNumber.MAX);
    }
}
