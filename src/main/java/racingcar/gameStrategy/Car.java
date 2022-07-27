package racingcar.gameStrategy;

final class Car {
    private final MovementStrategy movementStrategy;
    private final String name;

    private int position = 0; // TODO

    Car(MovementStrategy movementStrategy, String carName) {
        this.movementStrategy = movementStrategy;
        this.name = carName;
    }

    String name() {
        return name;
    }

    int position() {
        return position;
    }

    void move() {
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
