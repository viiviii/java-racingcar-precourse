package racingcar.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.rule.Name;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersDtoTest {

    @DisplayName("우승자 이름은 String 목록으로 리턴한다")
    @Test
    void get() {
        //given
        Name name = new Name("pobi");
        WinnersDto winnersDto = WinnersDto.from(Arrays.asList(name));

        //when
        List<String> actual = winnersDto.get();

        //then
        assertThat(actual).containsOnly(name.get());
    }

    @DisplayName("우승자 이름 목록은 항상 새로운 목록으로 반환된다")
    @Test
    void returnNewListWhenGetValues() {
        //given
        List<Name> origin = Collections.emptyList();
        WinnersDto winnersDto = WinnersDto.from(origin);

        //when
        List<String> copy = winnersDto.get();
        copy.add("other");

        //then
        assertThat(origin).isEmpty();
        assertThat(copy.size()).isOne();
    }
}