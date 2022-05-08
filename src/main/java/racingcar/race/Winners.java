package racingcar.race;

import racingcar.rule.Name;

import java.util.ArrayList;
import java.util.List;

public final class Winners {
    private final List<Name> winnerNames;

    private Winners(List<Name> winnerNames) {
        this.winnerNames = winnerNames;
    }

    public static Winners from(List<Name> winnerNames) {
        final List<Name> copy = new ArrayList<>(winnerNames);
        return new Winners(copy);
    }

    public boolean contains(Name name) {
        return winnerNames.contains(name);
    }

    public int number() {
        return winnerNames.size();
    }

    public List<String> get() {
        final List<String> names = new ArrayList<>();
        for (Name winnerName : winnerNames) {
            names.add(winnerName.get());
        }
        return names;
    }
}
