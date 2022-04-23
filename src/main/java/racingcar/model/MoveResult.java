package racingcar.model;

import racingcar.model.car.CarName;
import racingcar.model.car.Position;

public class MoveResult {
    private final CarName carName;
    private final Position position;

    public MoveResult(CarName carName, Position position) {
        this.carName = carName;
        this.position = position;
    }

    public int position() {
        return position.get();
    }

    public String carName() {
        return carName.get();
    }
}
