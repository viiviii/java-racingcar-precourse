package racingcar.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.rule.Name;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {
    private Name name = new Name("pobi");

    @DisplayName("우승자 이름을 추가할 수 있다")
    @Test
    void add() {
        //given
        Winners winners = new Winners();

        //when
        winners.add(name);

        //then
        assertThat(winners.add(name)).isTrue();
    }

    @DisplayName("우승자 인원을 구할 수 있다")
    @Test
    void size() {
        //given
        Winners winners = new Winners();

        //when
        winners.add(name);

        //then
        assertThat(winners.size()).isOne();
    }

    @DisplayName("우승자 이름은 String 목록으로 리턴한다")
    @Test
    void get() {
        //given
        Winners winners = new Winners();
        winners.add(name);

        //when
        List<String> actual = winners.get();

        //then
        assertThat(actual).containsOnly(name.get());
    }

    @DisplayName("우승자 이름 목록은 항상 새로운 목록에 담아 반환한다")
    @Test
    void returnNewListWhenGetValues() {
        //given
        Winners origin = new Winners();
        origin.add(name);

        //when
        List<String> copy = origin.get();
        copy.add("other");

        //then
        assertThat(origin.size()).isEqualTo(1);
        assertThat(copy.size()).isEqualTo(2);
    }
}