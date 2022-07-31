package racingcar.gameStrategy;

import racingcar.gamePlay.Movement;
import racingcar.gamePlay.Records;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class RememberingRecords implements Records {
    private final Map<String, Movements> carMovements = new HashMap<>();

    @Override
    public List<Movement> recordOf(String carName) {
        return movementsOf(carName).toList();
    }

    void save(String carName, Movement movement) {
        final Movements movements = movementsOf(carName);
        movements.add(movement);
        carMovements.put(carName, movements);
    }

    private Movements movementsOf(String carName) {
        return carMovements.getOrDefault(carName, new Movements());
    }

    private static final class Movements {
        private final List<Movement> value = new ArrayList<>();

        private void add(Movement movement) {
            value.add(movement);
        }

        private List<Movement> toList() {
            return new ArrayList<>(value);
        }
    }
}
