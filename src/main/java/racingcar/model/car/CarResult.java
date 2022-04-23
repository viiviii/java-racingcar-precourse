package racingcar.model.car;

public class CarResult {
    private final CarName carName;
    private final Position position;

    public CarResult(CarName carName, Position position) {
        this.carName = carName;
        this.position = position;
    }

    public int position() {
        return position.get();
    }

    public String name() {
        return carName.get();
    }
}
