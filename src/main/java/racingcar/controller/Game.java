package racingcar.controller;

import racingcar.model.Energy;
import racingcar.model.MoveCount;
import racingcar.model.car.Car;
import racingcar.model.car.CarResult;
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
        final Car car = inputCar();
        final MoveCount moveCount = inputMoveCount();
        final List<CarResult> result = start(car, moveCount);
        outputView.printResult(result);
    }

    private Car inputCar() {
        final String carName = inputView.inputCarName();
        return new Car(carName);
    }

    private MoveCount inputMoveCount() {
        final String inputMoveCount = inputView.inputMoveCount();
        return MoveCount.fromString(inputMoveCount);
    }

    private List<CarResult> start(Car car, MoveCount moveCount) {
        final List<CarResult> result = new ArrayList<>();
        for (int i = 0; i < moveCount.get(); i++) {
            final Energy energy = Energy.atRandom();
            final CarResult carResult = car.moveBy(energy);
            result.add(carResult);
        }
        return result;
    }
}
