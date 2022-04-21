package racingcar.view;

import racingcar.CarResult;
import racingcar.MoveCondition;
import racingcar.RacingPace;

public class OutputView {

    public void printRacingPace(CarResult carResult) {
        int forwardCount = carResult.forwardCount();
        final String pace = RacingPace.racingPace(forwardCount);
        System.out.println(pace);
    }
}
