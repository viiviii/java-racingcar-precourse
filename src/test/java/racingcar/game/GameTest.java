package racingcar.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import racingcar.race.CarFactory;
import racingcar.race.RacingCars;
import racingcar.race.WinnersReferee;
import racingcar.rule.MoveCount;
import racingcar.rule.NameDelimiter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class GameTest {
    private InputView inputView = mock(InputView.class);
    private OutputView outputView = mock(OutputView.class);
    private CarFactory carFactory = CarFactory.fromDefault();
    private NameDelimiter nameDelimiter = new NameDelimiter();
    private WinnersReferee winnersReferee = new WinnersReferee();
    private Game game = new Game(inputView, outputView, carFactory, nameDelimiter, winnersReferee);

    @DisplayName("자동차 경주 게임 플레이")
    @Test
    void play() {
        //given
        given(inputView.inputCarsNames()).willReturn("pobi");
        given(inputView.inputMoveCount()).willReturn("3");
        InOrder inOrder = inOrder(inputView, outputView);

        //when
        game.play();

        //then
        inOrder.verify(inputView).inputCarsNames();
        inOrder.verify(inputView).inputMoveCount();
        inOrder.verify(outputView).printResult(any());
    }

    @DisplayName("잘못된 자동차 이름인 경우 다시 입력 받는다")
    @Test
    void inputAgainWhenInvalidCarNames() {
        //given
        given(inputView.inputCarsNames()).willReturn("sixTxt", " ", "valid");

        //when
        game.createRacingCars();

        //then
        verify(inputView, times(3)).inputCarsNames();
    }

    @DisplayName("잘못된 시도 횟수인 경우 다시 입력 받는다")
    @Test
    void inputAgainWhenInvalidMoveCount() {
        //given
        given(inputView.inputMoveCount()).willReturn("-1", "0", "1");

        //when
        game.createMoveCount();

        //then
        verify(inputView, times(3)).inputMoveCount();
    }

    @DisplayName("이동 횟수만큼 자동차가 움직인다")
    @Test
    void startRaceWith() {
        //given
        RacingCars racingCars = mock(RacingCars.class);
        MoveCount moveCount = MoveCount.fromString("5");

        //when
        game.startRaceWith(racingCars, moveCount);

        //then
        verify(racingCars, times(moveCount.get())).move();
    }
}