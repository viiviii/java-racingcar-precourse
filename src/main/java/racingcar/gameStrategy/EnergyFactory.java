package racingcar.gameStrategy;

import camp.nextstep.edu.missionutils.Randoms;

public class EnergyFactory {

    public Energy random() {
        return Energy.valueOf(randomNumber());
    }

    private int randomNumber() {
        return Randoms.pickNumberInRange(Energy.MIN, Energy.MAX);
    }
}
