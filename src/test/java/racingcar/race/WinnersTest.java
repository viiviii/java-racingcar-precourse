package racingcar.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.rule.Name;
import racingcar.rule.Position;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    @DisplayName("가장 먼 위치의 자동차가 우승이다")
    @Test
    void winners() {
        //given
        Name expectedWinner = new Name("crong");
        MoveRecords moveRecords = new MoveRecords();
        moveRecords.recordOf(new Name("pobi"), new Position(1));
        moveRecords.recordOf(expectedWinner, new Position(9));
        moveRecords.recordOf(new Name("honux"), new Position(3));
        Winners winners = new Winners();

        //when
        List<Name> winnerNames = winners.determineFrom(moveRecords);

        //then
        assertThat(winnerNames).containsOnly(expectedWinner);
    }
}