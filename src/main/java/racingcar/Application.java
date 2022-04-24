package racingcar;

import racingcar.model.Energy;
import racingcar.model.MoveCount;
import racingcar.model.car.Car;
import racingcar.model.car.CarResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        String carName = inputView.inputCarName();
        Car car = new Car(carName);

        String inputMoveCount = inputView.inputMoveCount();
        MoveCount moveCount = MoveCount.fromString(inputMoveCount);

        for (int i = 0; i < moveCount.get(); i++) {
            Energy energy = Energy.atRandom();
            CarResult carResult = car.moveBy(energy);
            outputView.printCarResult(carResult);
        }
    }
}
