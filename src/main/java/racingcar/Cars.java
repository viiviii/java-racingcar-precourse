package racingcar;

import racingcar.model.Energy;
import racingcar.model.car.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    // TODO: 이걸 여기서 해야되나?
    public static Cars fromString(String names) {
        final List<Car> cars = new ArrayList<>();
        final String[] carsNames = names.split(","); // TODO
        for (String carName : carsNames) {
            cars.add(Car.inStartingPositionWith(carName));
        }
        return new Cars(cars);
    }

    public static Cars from(Car... cars) {
        return new Cars(Arrays.asList(cars));
    }

    // TODO: 필요없나 테스트에서만 쓰는데
    public int count() {
        return cars.size();
    }

    public List<CarResult> move() {
        final List<CarResult> result = new ArrayList<>();
        for (Car car : cars) {
            final Energy energy = Energy.atRandom();
            final int position = car.moveBy(energy);
            result.add(new CarResult(car.name(), position));
        }
        return result;
    }

    public List<String> getWinner() {
        final int raceMaxPosition = maxPosition();
        final List<String> names = new ArrayList<>();
        for (Car car : cars) {
            // TODO
            if (car.inPosition(raceMaxPosition)) {
                names.add(car.name());
            }
        }
        return names;
    }

    private int maxPosition() {
        return Collections
                .max(cars, Car::compareToPosition)
                .position();
    }
}
