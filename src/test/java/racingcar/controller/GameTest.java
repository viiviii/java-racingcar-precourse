package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class GameTest {
    InputView inputView = mock(InputView.class);
    OutputView outputView = mock(OutputView.class);

    @DisplayName("자동차 경주 게임 플레이")
    @Test
    void play() {
        //given
        Game game = new Game(inputView, outputView);

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
}