package racingcar;

import racingcar.controller.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        new Game(inputView, outputView).play();
    }
}
