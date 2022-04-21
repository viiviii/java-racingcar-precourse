package racingcar.view;

import racingcar.model.ForwardCount;
import racingcar.model.MoveResult;
import racingcar.model.RacingPace;

public class OutputView {

    public void printRacingPace(MoveResult moveResult) {
        final ForwardCount forwardCount = moveResult.forwardCount();
        final String pace = RacingPace.racingPace(forwardCount);
        System.out.println(pace);
    }
}
