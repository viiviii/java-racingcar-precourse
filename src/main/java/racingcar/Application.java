package racingcar;

import racingcar.model.Energy;
import racingcar.model.MoveCount;
import racingcar.model.MoveResult;
import racingcar.model.car.Car;
import racingcar.model.car.CarName;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.printCarNameRequest();
        String inputCarName = inputView.inputCarName();
        CarName carName = new CarName(inputCarName);

        outputView.printMoveCountRequest();
        String inputMoveCount = inputView.inputMoveCount();
        MoveCount moveCount = MoveCount.fromString(inputMoveCount);

        Car car = new Car(carName);
        for (int i = 0; i < moveCount.get(); i++) {
            Energy energy = Energy.atRandom();
            MoveResult moveResult = car.moveBy(energy);
            outputView.printMoveResult(moveResult);
        }
    }
}
