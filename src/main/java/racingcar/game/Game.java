package racingcar.game;

import racingcar.race.*;
import racingcar.rule.MoveCount;
import racingcar.rule.Name;
import racingcar.rule.NameDelimiter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Game {
    private final InputView inputView;
    private final OutputView outputView;
    private final CarFactory carFactory;
    private final NameDelimiter nameDelimiter;

    public Game(InputView inputView, OutputView outputView, CarFactory carFactory, NameDelimiter nameDelimiter) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carFactory = carFactory;
        this.nameDelimiter = nameDelimiter;
    }

    public void play() {
        final Race race = createRace();
        final MoveCount moveCount = createMoveCount();
        final List<List<CarDto>> result = race.startWith(moveCount);
        outputView.printResult(result);
        final Winners winners = race.getWinners();
        outputView.printWinners(winners);
    }

    Race createRace() {
        try {
            final String inputNames = inputView.inputCarsNames();
            final List<Name> delimitNames = nameDelimiter.delimit(inputNames);
            final List<Car> cars = carFactory.create(delimitNames);
            return Race.from(cars);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return createRace();
        }
    }

    MoveCount createMoveCount() {
        try {
            final String inputMoveCount = inputView.inputMoveCount();
            return MoveCount.fromString(inputMoveCount);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return createMoveCount();
        }
    }
}
