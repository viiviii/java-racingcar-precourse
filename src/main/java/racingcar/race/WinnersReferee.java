package racingcar.race;

import racingcar.rule.Name;
import racingcar.rule.Position;

import java.util.ArrayList;
import java.util.List;

public final class WinnersReferee {

    // TODO
    public List<Name> determineFrom(MoveRecords moveRecords) {
        final Position winningPosition = moveRecords.maxPosition();
        final List<Name> winners = new ArrayList<>();
        for (Name name : moveRecords.allNames()) {
            Position position = moveRecords.positionBy(name);
            if (position.equals(winningPosition)) {
                winners.add(name);
            }
        }
        return winners;
    }
}
