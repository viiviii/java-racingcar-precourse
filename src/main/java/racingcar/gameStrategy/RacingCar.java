package racingcar.gameStrategy;

import racingcar.gamePlay.Car;
import racingcar.gamePlay.Movable;

public final class RacingCar implements Car, Movable {
    private final MovementStrategy movementStrategy;
    private final String name;
    private Position position = Position.init();

    public RacingCar(MovementStrategy movementStrategy, String name) {
        this.movementStrategy = movementStrategy;
        this.name = name;
    }

    @Override
    public void move() {
        final Movement movement = movementStrategy.movement();
        if (movement.isForward()) {
            position = position.increase();
        }
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int position() {
        return position.value();
    }
}
