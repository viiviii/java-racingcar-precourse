package racingcar.game;

import racingcar.race.CarResult;
import racingcar.race.Race;
import racingcar.rule.MoveCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Game {
    private final InputView inputView;
    private final OutputView outputView;

    public Game(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        final Race race = Race.from(inputCarsNames());
        final MoveCount moveCount = inputMoveCount();
        final List<List<CarResult>> result = race.startWith(moveCount);
        outputView.printResult(result);
        final List<String> winners = race.getWinner(); // TODO
        outputView.printWinners(winners);
    }

    private String[] inputCarsNames() {
        final String names = inputView.inputCarsNames();
        return names.split(",");  // TODO
    }

    private MoveCount inputMoveCount() {
        final String inputMoveCount = inputView.inputMoveCount();
        return MoveCount.fromString(inputMoveCount);
    }
}
