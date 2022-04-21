package racingcar.view;

import racingcar.model.CarResult;
import racingcar.model.ForwardCount;
import racingcar.model.RacingPace;

public class OutputView {

    public void printRacingPace(CarResult carResult) {
        final ForwardCount forwardCount = carResult.forwardCount();
        final String pace = RacingPace.racingPace(forwardCount);
        System.out.println(pace);
    }
}
