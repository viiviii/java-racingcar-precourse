package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.CarName;
import racingcar.model.Distance;
import racingcar.model.Position;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    private OutputView outputView = new OutputView();

    @DisplayName("이동 결과 메세지")
    @Test
    void moveResultMessage() {
        //given
        CarName carName = new CarName("apple");
        Position position = Position.from(3);
        Distance distance = Distance.from(position);

        //when
        String actual = outputView.moveResultMessage(carName, distance);

        //then
        assertThat(actual).isEqualTo("apple : ---");
    }
}