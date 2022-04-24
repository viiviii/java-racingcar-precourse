package racingcar.controller;

import racingcar.Cars;
import racingcar.model.MoveCount;
import racingcar.model.car.CarResult;
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
        final Cars cars = inputCarsNames();
        final MoveCount moveCount = inputMoveCount();
        final List<List<CarResult>> result = cars.move(moveCount);
        outputView.printResult(result);
    }

    private Cars inputCarsNames() {
        final String names = inputView.inputCarsNames();
        return Cars.fromString(names);
    }

    private MoveCount inputMoveCount() {
        final String inputMoveCount = inputView.inputMoveCount();
        return MoveCount.fromString(inputMoveCount);
    }
}
