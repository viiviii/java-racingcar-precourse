package racingcar;

import racingcar.game.Game;
import racingcar.race.RacingCarsFactory;
import racingcar.race.WinnersReferee;
import racingcar.rule.NameDelimiter;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.message.Message;

public class Application {
    public static void main(String[] args) {
        final Message message = new Message();
        final InputView inputView = new InputView(message);
        final OutputView outputView = new OutputView(System.out, message);
        final RacingCarsFactory racingCarsFactory = new RacingCarsFactory();
        final NameDelimiter nameDelimiter = new NameDelimiter();
        final WinnersReferee winnersReferee = new WinnersReferee();
        // TODO: 부자다 부자
        new Game(inputView, outputView, racingCarsFactory, nameDelimiter, winnersReferee)
                .play();
    }
}
