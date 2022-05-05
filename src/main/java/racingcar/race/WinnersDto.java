package racingcar.race;

import racingcar.rule.Name;

import java.util.ArrayList;
import java.util.List;

public class WinnersDto {
    private final List<Name> winnerNames;

    private WinnersDto(List<Name> winnerNames) {
        this.winnerNames = winnerNames;
    }

    public static WinnersDto from(List<Name> winnerNames) {
        final List<Name> copy = new ArrayList<>(winnerNames);
        return new WinnersDto(copy);
    }

    public List<String> get() {
        final List<String> names = new ArrayList<>();
        for (Name winnerName : winnerNames) {
            names.add(winnerName.get());
        }
        return names;
    }
}
