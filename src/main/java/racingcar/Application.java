package racingcar;

import racingcar.model.*;
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

        Car car = new Car(new MyRandoms(), carName, new MoveCondition()); // TODO: 임시
        for (int i = 0; i < moveCount.get(); i++) {
            MoveResult moveResult = car.move();
            outputView.printMoveResult(moveResult);
        }
    }
}
