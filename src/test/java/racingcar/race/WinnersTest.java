package racingcar.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.rule.Name;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    @DisplayName("우승자에 해당 이름이 포함됐는지 확인할 수 있다")
    @Test
    void contains() {
        //given
        Name name = new Name("pobi");
        Winners winners = Winners.from(Arrays.asList(name));

        //when
        boolean contains = winners.contains(name);

        //then
        assertThat(contains).isTrue();
    }

    @DisplayName("우승자가 몇 명인지 확인할 수 있다")
    @Test
    void number() {
        //given
        Name name = new Name("pobi");
        Winners winners = Winners.from(Arrays.asList(name));

        //when
        int numberOfWinners = winners.number();

        //then
        assertThat(numberOfWinners).isOne();
    }

    @DisplayName("우승자의 이름을 문자열 목록으로 가져올 수 있다")
    @Test
    void get() {
        //given
        String name1 = "pobi";
        String name2 = "honux";
        List<Name> names = Arrays.asList(new Name(name1), new Name(name2));
        Winners winners = Winners.from(names);

        //when
        List<String> winnerNames = winners.get();

        //then
        assertThat(winnerNames).containsExactly(name1, name2);
    }
}
