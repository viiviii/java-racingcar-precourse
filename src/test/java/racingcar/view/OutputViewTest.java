package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.CarName;
import racingcar.model.ForwardCount;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    private OutputView outputView = new OutputView();

    @DisplayName("이동 결과 메세지")
    @Test
    void moveResultMessage() {
        //given
        CarName carName = new CarName("apple");
        ForwardCount forwardCount = new ForwardCount(3);

        //when
        String actual = outputView.moveResultMessage(carName, forwardCount);

        //then
        assertThat(actual).isEqualTo("apple : ---");
    }
}