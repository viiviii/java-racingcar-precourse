package racingcar;

import racingcar.model.Energy;
import racingcar.model.MoveCount;
import racingcar.model.car.Car;
import racingcar.model.car.CarResult;

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

    // TODO
    public List<List<CarResult>> move(MoveCount moveCount) {
        final List<List<CarResult>> result = new ArrayList<>();
        for (int i = 0; i < moveCount.get(); i++) {
            final List<CarResult> moveCar = move();
            result.add(moveCar);
        }
        return result;
    }

    // TODO
    private List<CarResult> move() {
        final List<CarResult> result = new ArrayList<>();
        for (Car car : cars) {
            final Energy energy = Energy.atRandom();
            final CarResult carResult = car.moveBy(energy);
            result.add(carResult);
        }
        return result;
    }
}
