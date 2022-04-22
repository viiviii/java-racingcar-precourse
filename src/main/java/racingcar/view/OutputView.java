package racingcar.view;

import racingcar.model.CarName;
import racingcar.model.Distance;
import racingcar.model.MoveResult;
import racingcar.model.Position;

public class OutputView {

    public void printCarNameRequest() {
        output("경주할 자동차 이름을 입력하세요."); // TODO: 여러대 올 때 메세지 변경
    }

    public void printMoveCountRequest() {
        output("시도할 회수는 몇회인가요?");
    }

    public void printRacingPace(MoveResult moveResult) {
        final CarName carName = moveResult.carName();
        final Position position = moveResult.position();
        output(moveResultMessage(carName, position));
    }

    String moveResultMessage(CarName carName, Position position) {
        final String distance = Distance.from(position);
        return String.format("%s : %s", carName.get(), distance);
    }

    private void output(String message) {
        System.out.println(message);
    }
}
