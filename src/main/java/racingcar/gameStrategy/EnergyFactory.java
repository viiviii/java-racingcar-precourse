package racingcar.gameStrategy;

import camp.nextstep.edu.missionutils.Randoms;

public class EnergyFactory {

    public MovementNumber random() {
        return MovementNumber.valueOf(randomNumber());
    }

    private int randomNumber() {
        return Randoms.pickNumberInRange(MovementNumber.MIN, MovementNumber.MAX);
    }
}
