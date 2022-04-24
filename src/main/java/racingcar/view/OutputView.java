package racingcar.view;

import racingcar.model.car.CarResult;
import racingcar.view.message.Distance;
import racingcar.view.message.Message;

import java.io.PrintStream;
import java.util.List;

// TODO: Result만 어떻게 하면 테스트 할 수 있을 것 같애
public class OutputView {
    private final PrintStream output;
    private final Message message;

    public OutputView(PrintStream output, Message message) {
        this.output = output;
        this.message = message;
    }

    public void printResult(List<List<CarResult>> result) {
        printTitle();
        printContentWith(result);
    }

    private void printTitle() {
        output.println();
        output.println(message.resultTitle());
    }

    private void printContentWith(List<List<CarResult>> result) {
        for (List<CarResult> carResults : result) {
            printMoveDistancesWith(carResults);
            output.println();
        }
    }

    private void printMoveDistancesWith(List<CarResult> result) {
        for (CarResult carResult : result) {
            final String carName = carResult.name();
            final Distance distance = Distance.from(carResult.position());
            output.println(message.moveDistance(carName, distance));
        }
    }
}
