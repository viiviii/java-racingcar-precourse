package racingcar.model.car;

public class CarResult {
    private final Name name;
    private final Position position;

    public CarResult(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public int position() {
        return position.get();
    }

    public String name() {
        return name.get();
    }
}
