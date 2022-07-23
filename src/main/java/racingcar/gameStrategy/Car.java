package racingcar.gameStrategy;

public final class Car {
    private final MovementStrategy movementStrategy;
    private final String name;
    private int position = 0;

    public Car(MovementStrategy movementStrategy, String carName) {
        this.movementStrategy = movementStrategy;
        this.name = carName;
    }

    public String name() {
        return name;
    }

    public int position() {
        return position;
    }

    public int move() {
        final Movement movement = movementStrategy.movement();
        if (movement.isForward()) {
            increasePosition();
        }
        return position();
    }

    private void increasePosition() {
        position += 1;
    }
}
