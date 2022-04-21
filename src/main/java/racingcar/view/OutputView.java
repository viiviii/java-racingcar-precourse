package racingcar.view;

import racingcar.CarResult;
import racingcar.ForwardCount;
import racingcar.RacingPace;

public class OutputView {

    public void printRacingPace(CarResult carResult) {
        final ForwardCount forwardCount = carResult.forwardCount();
        final String pace = RacingPace.racingPace(forwardCount);
        System.out.println(pace);
    }
}
