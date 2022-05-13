package racingcar.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.rule.Name;
import racingcar.rule.Position;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersRefereeTest {

    @DisplayName("우승자를 판별한다")
    @Test
    void winners() {
        //given
        Name expectedWinner = new Name("crong");
        MoveRecords moveRecords = new MoveRecords();
        moveRecords.recordOf(new Name("name1"), new Position(1));
        moveRecords.recordOf(expectedWinner, new Position(9));
        moveRecords.recordOf(new Name("name2"), new Position(3));

        //when
        WinnersReferee winnersReferee = new WinnersReferee();
        Winners winners = winnersReferee.determineFrom(moveRecords);

        //then
        assertThat(winners.contains(expectedWinner)).isTrue();
        assertThat(winners.number()).isOne();
    }
}