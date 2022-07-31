package racingcar.gameStrategy;

import racingcar.gamePlay.Car;
import racingcar.gamePlay.Movement;

public final class RacingCar implements Car {
    private final RememberingState state = new RememberingState(); // TODO
    private final MovementStrategy movementStrategy;
    private final String name;

    RacingCar(MovementStrategy movementStrategy, String name) {
        this.movementStrategy = movementStrategy;
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public State state() {
        return state;
    }

    @Override
    public void move() {
        final Movement movement = movementStrategy.movement();
        state.save(movement);
    }
}
