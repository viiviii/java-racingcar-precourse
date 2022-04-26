package racingcar.race;

import racingcar.rule.Name;
import racingcar.rule.Position;

public class CarDto {
    private final Name name;
    private final Position position;

    private CarDto(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public static CarDto from(Car car) {
        return new CarDto(car.name(), car.position());
    }

    public int position() {
        return position.get();
    }

    public String name() {
        return name.get();
    }
}
