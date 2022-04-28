package racingcar.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.rule.Name;
import racingcar.rule.Position;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {
    private Position winningPosition = new Position(5);
    private Name winningCarName = new Name("pobi");
    private Winners winners = Winners.asMaxPosition(winningPosition);

    @DisplayName("자동차의 거리가 레이싱 최대 거리이면 값이 추가된다")
    @Test
    void addReturnTrueWhenWinners() {
        //when
        boolean actual = winners.addIfMaxPosition(winningPosition, winningCarName);

        //then
        assertThat(actual).isTrue();
    }

    @DisplayName("자동차의 거리가 레이싱 최대 거리가 아니면 값은 추가되지 않는다")
    @Test
    void addReturnFalseWhenNotWinners() {
        //given
        Position lessPosition = Position.start();
        Name name = new Name("user");

        //when
        boolean actual = winners.addIfMaxPosition(lessPosition, name);

        //then
        assertThat(actual).isFalse();
    }

    @DisplayName("우승자 인원을 구할 수 있다")
    @Test
    void size() {
        //when
        winners.addIfMaxPosition(winningPosition, winningCarName);

        //then
        assertThat(winners.size()).isOne();
    }

    @DisplayName("우승자 이름은 String 목록으로 리턴한다")
    @Test
    void get() {
        //when
        winners.addIfMaxPosition(winningPosition, winningCarName);
        List<String> actual = winners.get();

        //then
        assertThat(actual).containsOnly(winningCarName.get());
    }

    @DisplayName("우승자 이름 목록은 항상 새로운 목록에 담아 반환한다")
    @Test
    void returnNewListWhenGetValues() {
        //when
        List<String> copy = winners.get();
        copy.add("other");

        //then
        assertThat(winners.size()).isZero();
        assertThat(copy.size()).isOne();
    }
}