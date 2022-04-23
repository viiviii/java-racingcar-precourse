package racingcar.view;

import racingcar.model.Distance;
import racingcar.model.MoveResult;

public class OutputView {

    public void printCarNameRequest() {
        output("경주할 자동차 이름을 입력하세요."); // TODO: 여러대 올 때 메세지 변경
    }

    public void printMoveCountRequest() {
        output("시도할 회수는 몇회인가요?");
    }

    public void printMoveResult(MoveResult moveResult) {
        final String carName = moveResult.carName();
        final Distance distance = Distance.from(moveResult.position());
        output(moveResultMessage(carName, distance));
    }

    String moveResultMessage(String carName, Distance distance) {
        return String.format("%s : %s", carName, distance.get());
    }

    private void output(String message) {
        System.out.println(message);
    }
}
