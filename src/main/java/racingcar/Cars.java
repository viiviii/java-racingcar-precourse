package racingcar;

import racingcar.model.Energy;
import racingcar.model.car.Car;
import racingcar.model.car.CarResult;

import java.util.ArrayList;
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
            cars.add(new Car(carName));
        }
        return new Cars(cars);
    }

    // TODO: 필요없나 테스트에서만 쓰는데
    public int count() {
        return cars.size();
    }

    // TODO: 여기에선 CarResult에서 모델 사용하고 controller인 game에서 DTO로 변환 가능?
    public List<CarResult> move() {
        final List<CarResult> result = new ArrayList<>();
        for (Car car : cars) {
            final Energy energy = Energy.atRandom();
            final CarResult carResult = car.moveBy(energy);
            result.add(carResult);
        }
        return result;
    }
}
