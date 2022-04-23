package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Distance;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {
    private OutputView outputView = new OutputView();

    @DisplayName("이동 결과 메세지 형식은 {자동차이름 : 거리}이다")
    @Test
    void carResultMessage() {
        //given
        String carName = "apple";
        Distance distance = Distance.from(3);

        //when
        String actual = outputView.carResultMessage(carName, distance);

        //then
        assertThat(actual).isEqualTo("apple : ---");
    }
}