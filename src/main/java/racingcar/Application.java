package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        String inputMoveCount = inputView.inputMoveCount();
        MoveCount moveCount = MoveCount.fromString(inputMoveCount);

        Car car = new Car();
        for (int i = 0; i < moveCount.get(); i++) {
            CarResult carResult = car.move();
            outputView.printRacingPace(carResult);
        }
    }
}
