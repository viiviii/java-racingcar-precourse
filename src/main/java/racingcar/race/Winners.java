package racingcar.race;

import racingcar.rule.Name;
import racingcar.rule.Position;

import java.util.*;

public final class Winners {
    private Map<Position, Names> record = new HashMap<>();

    public List<Name> determineFrom(List<Car> cars) {
        doRecord(cars);
        return names(winningPosition()).toList();
    }

    private void doRecord(List<Car> cars) {
        for (Car car : cars) {
            final Position position = car.position();
            final Names names = names(position);
            record.put(position, names.add(car.name()));
        }
    }

    private Names names(Position position) {
        return record.getOrDefault(position, new Names());
    }

    Position winningPosition() {
        return Collections.max(record.keySet());
    }

    private static final class Names {
        private List<Name> names = new ArrayList<>();

        private Names add(Name name) {
            names.add(name);
            return this;
        }

        private List<Name> toList() {
            return new ArrayList<>(names);
        }
    }
}
