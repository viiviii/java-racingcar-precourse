package racingcar.race;

import racingcar.rule.Name;
import racingcar.rule.Position;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class MoveRecords {
    private Map<Name, Position> records = new HashMap<>();

    public boolean recordOf(Name name, Position position) {
        records.put(name, position);
        return records.containsKey(name);
    }

    public Position positionBy(Name name) {
        return records.get(name);
    }

    public Set<Name> allNames() {
        return records.keySet();
    }

    public Collection<Position> allPositions() {
        return records.values();
    }
}
