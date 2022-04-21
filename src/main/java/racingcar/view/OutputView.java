package racingcar.view;

import racingcar.MoveCondition;
import racingcar.RacingPace;

public class OutputView {

    public void printRacingPace(MoveCondition moveCondition) {
        final String pace = RacingPace.racingPace(moveCondition);
        System.out.println(pace);
    }
}
