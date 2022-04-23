package racingcar.view;

import racingcar.model.Distance;
import racingcar.model.car.CarResult;

public class OutputView {

    public void printCarNameRequest() {
        output("경주할 자동차 이름을 입력하세요."); // TODO: 여러대 올 때 메세지 변경
    }

    public void printMoveCountRequest() {
        output("시도할 회수는 몇회인가요?");
    }

    public void printCarResult(CarResult carResult) {
        final String carName = carResult.name();
        final Distance distance = Distance.from(carResult.position());
        output(carResultMessage(carName, distance));
    }

    String carResultMessage(String carName, Distance distance) {
        return String.format("%s : %s", carName, distance.get());
    }

    private void output(String message) {
        System.out.println(message);
    }
}
