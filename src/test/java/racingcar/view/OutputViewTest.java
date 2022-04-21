package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.CarName;
import racingcar.model.ForwardCount;
import racingcar.model.MoveResult;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    private OutputView outputView = new OutputView();

    @DisplayName("이동 결과 메세지")
    @Test
    void moveResultMessage() {
        //given
        CarName carName = new CarName("apple");
        ForwardCount forwardCount = new ForwardCount(3);
        MoveResult moveResult = new MoveResult(carName, forwardCount);

        //when
        String actual = outputView.moveResultMessage(moveResult);

        //then
        assertThat(actual).isEqualTo("apple : ---");
    }
}