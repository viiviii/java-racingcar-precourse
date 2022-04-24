package racingcar.view;

import racingcar.model.Distance;
import racingcar.model.car.CarResult;

import java.util.List;

public class OutputView {

    public void printResult(List<CarResult> result) {
        printNewLine();
        print("실행 결과");
        for (CarResult carResult : result) {
            printCarPosition(carResult);
            printNewLine();
        }
    }

    private void printCarPosition(CarResult carResult) {
        final String carName = carResult.name();
        final Distance distance = Distance.from(carResult.position());
        print(carResultMessage(carName, distance));
    }

    String carResultMessage(String carName, Distance distance) {
        return String.format("%s : %s", carName, distance.get());
    }

    private void print(String message) {
        System.out.println(message);
    }

    private void printNewLine() {
        System.out.println();
    }
}
