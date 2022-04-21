package racingcar;

import racingcar.model.Car;
import racingcar.model.MoveCount;
import racingcar.model.MoveResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.printCarNameRequest();
        String inputCarName = inputView.inputCarName();

        outputView.printMoveCountRequest();
        String inputMoveCount = inputView.inputMoveCount();
        MoveCount moveCount = MoveCount.fromString(inputMoveCount);

        Car car = new Car();
        for (int i = 0; i < moveCount.get(); i++) {
            MoveResult moveResult = car.move();
            outputView.printRacingPace(moveResult);
        }
    }
}
