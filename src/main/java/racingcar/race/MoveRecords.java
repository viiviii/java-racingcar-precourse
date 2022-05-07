package racingcar.race;

import racingcar.rule.Name;
import racingcar.rule.Position;

import java.util.HashMap;
import java.util.Map;

public final class MoveRecords {
    private Map<Name, Position> records = new HashMap<>();

    // TODO: recordOf 이런 값이 변하는 메서드는 최대한 숨기고 싶어
    public boolean recordOf(Name name, Position position) {
        records.put(name, position);
        return records.containsKey(name);
    }

    public Position positionBy(Name name) {
        return records.get(name);
    }

    public Iterable<Name> allNames() {
        return records.keySet();
    }
}
