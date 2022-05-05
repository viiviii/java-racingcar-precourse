package racingcar.race;

import racingcar.rule.Name;
import racingcar.rule.Position;

import java.util.ArrayList;
import java.util.List;

public final class Winners {
    private final List<Name> winnerNames = new ArrayList<>();
    private final Position maxPosition;

    private Winners(Position position) {
        this.maxPosition = position;
    }

    public static Winners asMaxPosition(Position position) {
        return new Winners(position);
    }

    public int size() {
        return winnerNames.size();
    }

    public boolean addIfMaxPosition(Position position, Name name) {
        if (!position.equals(maxPosition)) {
            return false;
        }
        return winnerNames.add(name);
    }

    public WinnersDto get() {
        return WinnersDto.from(winnerNames);
    }
}
