package racingcar.race;

public class CarResult {
    private final String name;
    private final int position;

    public CarResult(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public int position() {
        return position;
    }

    public String name() {
        return name;
    }
}
