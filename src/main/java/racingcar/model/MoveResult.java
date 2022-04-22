package racingcar.model;

public class MoveResult {
    private final CarName carName;
    private final Position position;

    public MoveResult(CarName carName, Position position) {
        this.carName = carName;
        this.position = position;
    }

    public Position position() {
        return position;
    }

    public CarName carName() {
        return carName;
    }
}
