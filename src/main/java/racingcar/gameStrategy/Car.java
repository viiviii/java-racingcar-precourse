package racingcar.gameStrategy;

public final class Car {
    private final MovementStrategy movementStrategy;
    private final String name;

    private int position = 0; // TODO

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

    public void move() {
        if (canForward()) {
            increasePosition();
        }
    }

    private boolean canForward() {
        final Movement movement = movementStrategy.movement();
        return movement.isForward();
    }

    private void increasePosition() {
        position += 1;
    }
}
