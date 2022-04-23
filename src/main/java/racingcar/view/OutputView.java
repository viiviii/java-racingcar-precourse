package racingcar.view;

import racingcar.model.Distance;
import racingcar.model.MoveResult;
import racingcar.model.car.CarName;
import racingcar.model.car.Position;

public class OutputView {

    public void printCarNameRequest() {
        output("경주할 자동차 이름을 입력하세요."); // TODO: 여러대 올 때 메세지 변경
    }

    public void printMoveCountRequest() {
        output("시도할 회수는 몇회인가요?");
    }

    public void printMoveResult(MoveResult moveResult) {
        final CarName carName = moveResult.carName();
        final Position position = moveResult.position();
        output(moveResultMessage(carName, position));
    }

    String moveResultMessage(CarName carName, Position position) {
        final Distance distance = Distance.from(position);
        return String.format("%s : %s", carName.get(), distance.get());
    }

    private void output(String message) {
        System.out.println(message);
    }
}
