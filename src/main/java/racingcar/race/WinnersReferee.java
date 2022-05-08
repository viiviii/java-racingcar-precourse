package racingcar.race;

import racingcar.rule.Name;
import racingcar.rule.Position;

import java.util.ArrayList;
import java.util.List;

public final class WinnersReferee {

    // TODO
    public Winners determineFrom(MoveRecords moveRecords) {
        final Position winningPosition = moveRecords.maxPosition();
        final List<Name> winnerNames = new ArrayList<>();
        for (Name name : moveRecords.allNames()) {
            final Position position = moveRecords.positionBy(name);
            if (position.equals(winningPosition)) {
                winnerNames.add(name);
            }
        }
        return Winners.from(winnerNames);
    }
}
