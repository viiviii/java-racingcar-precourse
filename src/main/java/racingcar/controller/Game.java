package racingcar.controller;

import racingcar.CarResult;
import racingcar.Cars;
import racingcar.model.MoveCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final InputView inputView;
    private final OutputView outputView;

    public Game(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        final Cars cars = inputCarsNames();
        final MoveCount moveCount = inputMoveCount();
        final List<List<CarResult>> result = startRaceWith(cars, moveCount);
        outputView.printResult(result);
        final List<String> winners = cars.getWinner(); // TODO
        outputView.printWinners(winners);
    }

    private Cars inputCarsNames() {
        final String names = inputView.inputCarsNames();
        return Cars.fromString(names);
    }

    private MoveCount inputMoveCount() {
        final String inputMoveCount = inputView.inputMoveCount();
        return MoveCount.fromString(inputMoveCount);
    }

    private List<List<CarResult>> startRaceWith(Cars cars, MoveCount moveCount) {
        final List<List<CarResult>> result = new ArrayList<>();
        for (int i = 0; i < moveCount.get(); i++) {
            final List<CarResult> moveCar = cars.move();
            result.add(moveCar);
        }
        return result;
    }
}
