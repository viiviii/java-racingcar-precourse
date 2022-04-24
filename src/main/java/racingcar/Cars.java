package racingcar;

import racingcar.model.car.Car;

import java.util.ArrayList;
import java.util.List;

public final class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars fromString(String names) {
        final List<Car> cars = new ArrayList<>();
        final String[] carsNames = names.split(","); // TODO
        for (String carName : carsNames) {
            cars.add(new Car(carName));
        }
        return new Cars(cars);
    }

    public int count() {
        return cars.size();
    }
}
