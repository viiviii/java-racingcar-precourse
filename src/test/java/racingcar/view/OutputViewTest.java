package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.CarName;
import racingcar.model.Position;

class OutputViewTest {

    private OutputView outputView = new OutputView();

    @DisplayName("이동 결과 메세지")
    @Test
    void moveResultMessage() {
        //given
        CarName carName = new CarName("apple");
        Position position = new Position(3);

        //when
        String actual = outputView.moveResultMessage(carName, position);

        //then
        assertThat(actual).isEqualTo("apple : ---");
    }
}