package racingcar.race;

import racingcar.rule.Engine;
import racingcar.rule.Position;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    private final Engine engine;
    private final Position position;

    private CarFactory(Engine engine, Position position) {
        this.engine = engine;
        this.position = position;
    }

    public static CarFactory fromDefault() {
        final Engine engine = new Engine(new EnergyFactory());
        final Position position = Position.start();
        return CarFactory.from(engine, position);
    }

    public static CarFactory from(Engine engine, Position position) {
        return new CarFactory(engine, position);
    }

    public List<Car> create(String model) {
        final String[] names = model.split(","); // TODO: , 문자열 포장
        final List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(Car.of(engine, position, name));
        }
        return cars;
    }

    public Car of(Position position, String name) {
        return Car.of(engine, position, name);
    }
}
