package racingcar.race;

import racingcar.rule.Engine;
import racingcar.rule.Name;
import racingcar.rule.Position;

import java.util.ArrayList;
import java.util.List;

public class RacingCarsFactory {

    public RacingCars create(List<Name> names) {
        final List<Car> cars = new ArrayList<>();
        for (Name name : names) {
            final Car car = createDefaultCarWith(name);
            cars.add(car);
        }
        return RacingCars.from(cars);
    }

    private Car createDefaultCarWith(Name name) {
        final Engine engine = createDefaultEngineWithDefaultEnergyFactory();
        final Position position = createDefaultStartPosition();
        return Car.of(engine, name, position);
    }

    private Engine createDefaultEngineWithDefaultEnergyFactory() {
        return new Engine(new EnergyFactory());
    }

    private Position createDefaultStartPosition() {
        return Position.start();
    }
}
