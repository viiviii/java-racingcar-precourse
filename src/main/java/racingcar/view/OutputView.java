package racingcar.view;

import racingcar.model.Distance;
import racingcar.model.car.CarResult;

public class OutputView {

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
