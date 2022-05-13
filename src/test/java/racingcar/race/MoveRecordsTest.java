package racingcar.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.rule.Name;
import racingcar.rule.Position;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

class MoveRecordsTest {

//    void tmp() {
//        RaceResult raceResult = new RaceResult();
//
//        Iterable<MoveNumber> moveCount = raceResult.getMoveCount();
//        for (MoveNumber moveNumber : moveCount) {
//            MoveRecord moveRecord = raceResult.moveRecordAt(moveNumber);
//            printMoveDistancesWith(moveRecord);
//        }
//        ///////////////////
//        Iterable<Name> names = moveRecord.getRacingCarNames();
//        for (Name name : names) {
//            Position position = moveRecord.positionWith(name);
//            final Distance distance = Distance.from(position);
//            output.println(message.moveDistance(name, distance));
//        }
//    }

    @DisplayName("이동 결과를 기록한다")
    @Test
    void record() {
        //given
        MoveRecords moveRecords = new MoveRecords();

        //when
        boolean recorded = moveRecords.recordOf(new Name("pobi"), new Position(5));

        //then
        assertThat(recorded).isTrue();
    }

    @DisplayName("이름으로 이동한 위치 값을 구할 수 있다")
    @Test
    void position() {
        //given
        Name name = new Name("pobi");
        Position expectedPosition = new Position(5);
        MoveRecords moveRecords = new MoveRecords();

        //when
        moveRecords.recordOf(name, expectedPosition);
        Position recordedPosition = moveRecords.positionBy(name);

        //then
        assertThat(recordedPosition).isEqualTo(expectedPosition);
    }

    @DisplayName("기록된 모든 자동차의 이름을 구할 수 있다")
    @Test
    void allNames() {
        //given
        Name name1 = new Name("pobi");
        Name name2 = new Name("honux");
        Position position = new Position(5);

        //when
        MoveRecords moveRecords = new MoveRecords();
        moveRecords.recordOf(name1, position);
        moveRecords.recordOf(name2, position);
        Iterable<Name> names = moveRecords.allNames();

        //then
        assertThat(names).containsExactlyInAnyOrder(name1, name2);
    }

    @DisplayName("기록된 모든 위치를 구할 수 있다")
    @Test
    void allPositions() {
        //given
        Position position1 = new Position(3);
        Position position2 = new Position(5);

        //when
        MoveRecords moveRecords = new MoveRecords();
        moveRecords.recordOf(new Name("a"), position1);
        moveRecords.recordOf(new Name("b"), position2);
        moveRecords.recordOf(new Name("c"), position2);
        Collection<Position> positions = moveRecords.allPositions();

        //then
        assertThat(positions).containsExactly(position1, position2, position2);
    }
}
