package racingcar.gameStrategy;

import racingcar.gamePlay.Movement;

final class Car {
    private final MovementStrategy movementStrategy;
    private final String name;

    Car(MovementStrategy movementStrategy, String carName) {
        this.movementStrategy = movementStrategy;
        this.name = carName;
    }

    String name() {
        return name;
    }

    Movement move() {
        return movementStrategy.movement();
    }
}
