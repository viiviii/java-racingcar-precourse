package racingcar;

import racingcar.game.Game;
import racingcar.race.CarFactory;
import racingcar.rule.Position;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.message.Message;

public class Application {
    public static void main(String[] args) {
        final Message message = new Message();
        final InputView inputView = new InputView(message);
        final OutputView outputView = new OutputView(System.out, message);
        final CarFactory carFactory = CarFactory.from(Position.start()); // TODO

        new Game(inputView, outputView, carFactory).play();
    }
}
