package racingcar.race;

import racingcar.rule.Position;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    private final Position position;

    private CarFactory(Position position) {
        this.position = position;
    }

    public static CarFactory from(Position position) {
        return new CarFactory(position);
    }

    public List<Car> create(String model) {
        final String[] names = model.split(","); // TODO: , 문자열 포장
        final List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(Car.of(name, position));
        }
        return cars;
    }
}
