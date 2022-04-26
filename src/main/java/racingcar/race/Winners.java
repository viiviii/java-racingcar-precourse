package racingcar.race;

import racingcar.rule.Name;

import java.util.ArrayList;
import java.util.List;

public final class Winners {
    private List<String> value = new ArrayList<>();

    public boolean add(Name winner) {
        return value.add(winner.get());
    }

    public int size() {
        return value.size();
    }

    public List<String> get() {
        return new ArrayList<>(value);
    }


}
