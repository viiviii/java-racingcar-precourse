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

    public boolean addIfMaxPosition(Car car) {
        if (!car.inPosition(maxPosition)) {
            return false;
        }
        return winnerNames.add(car.name());
    }

    public List<String> get() {
        final List<String> names = new ArrayList<>();
        for (Name winnerName : winnerNames) {
            names.add(winnerName.get());
        }
        return names;
    }
}
