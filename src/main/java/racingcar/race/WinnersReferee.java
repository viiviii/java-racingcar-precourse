package racingcar.race;

import racingcar.rule.Name;
import racingcar.rule.Position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public final class WinnersReferee {

    // TODO
    public Winners determineFrom(MoveRecords moveRecords) {
        final Predicate<Name> isWinner = criteriaBy(moveRecords);
        final List<Name> winners = new ArrayList<>();
        for (Name name : moveRecords.allNames()) {
            if (isWinner.test(name)) {
                winners.add(name);
            }
        }
        return Winners.from(winners);
    }

    private Predicate<Name> criteriaBy(MoveRecords moveRecords) {
        final Position winningPosition = Collections.max(moveRecords.allPositions());
        return name -> moveRecords.positionBy(name).equals(winningPosition);
    }
}
