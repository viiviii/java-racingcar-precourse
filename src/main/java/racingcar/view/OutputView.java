package racingcar.view;

import racingcar.race.MoveRecords;
import racingcar.race.Winners;
import racingcar.rule.Name;
import racingcar.rule.Position;
import racingcar.view.message.Distance;
import racingcar.view.message.Message;

import java.io.PrintStream;
import java.util.List;

public class OutputView {
    private final PrintStream output;
    private final Message message;

    public OutputView(PrintStream output, Message message) {
        this.output = output;
        this.message = message;
    }

    public void printResult(List<MoveRecords> result) {
        printTitle();
        printContentWith(result);
    }

    private void printTitle() {
        output.println();
        output.println(message.resultTitle());
    }

    private void printContentWith(List<MoveRecords> result) {
        for (MoveRecords moveRecords : result) {
            printMoveDistancesWith(moveRecords);
            output.println();
        }
    }

    // TODO: 정리
    private void printMoveDistancesWith(MoveRecords moveRecords) {
        for (Name name : moveRecords.allNames()) {
            final Position position = moveRecords.positionBy(name);
            final Distance distance = Distance.from(position.get());
            output.println(message.moveDistance(name.get(), distance));
        }
    }

    public void printWinners(Winners winners) {
        output.println(message.winners(winners.get()));
    }


    public void printError(String errorMessage) {
        output.println(message.error(errorMessage));
    }
}
