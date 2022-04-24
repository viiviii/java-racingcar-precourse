package racingcar.view;

import racingcar.model.Distance;
import racingcar.model.car.CarResult;

import java.io.PrintStream;
import java.util.List;

public class OutputView {
    private final PrintStream output = System.out;

    public void printResult(List<List<CarResult>> result) {
        printTitle();
        printContentWith(result);
    }

    private void printTitle() {
        output.printf("%n실행 결과%n");
    }

    private void printContentWith(List<List<CarResult>> result) {
        for (List<CarResult> carResults : result) {
            printCarDistancesWith(carResults);
            output.println();
        }
    }

    private void printCarDistancesWith(List<CarResult> result) {
        for (CarResult carResult : result) {
            final String carName = carResult.name();
            final Distance distance = Distance.from(carResult.position());
            output.printf("%s : %s%n", carName, distance.get());
        }
    }
}
