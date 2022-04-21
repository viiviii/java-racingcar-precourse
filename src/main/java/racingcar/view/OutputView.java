package racingcar.view;

import racingcar.model.ForwardCount;
import racingcar.model.MoveResult;
import racingcar.model.RacingPace;

public class OutputView {

    public void printCarNameRequest() {
        output("경주할 자동차 이름을 입력하세요."); // TODO: 여러대 올 때 메세지 변경
    }

    public void printMoveCountRequest() {
        output("시도할 회수는 몇회인가요?");
    }

    public void printRacingPace(MoveResult moveResult) {
        final String pace = moveResultMessage(moveResult);
        output(pace);
    }

    String moveResultMessage(MoveResult moveResult) {
        final ForwardCount forwardCount = moveResult.forwardCount();
        final String pace = RacingPace.racingPace(forwardCount);
        return moveResult.carName().get() + " : " + pace;
    }

    private void output(String message) {
        System.out.println(message);
    }
}
