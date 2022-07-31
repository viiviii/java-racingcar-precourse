package racingcar.gameStrategy;

import racingcar.gamePlay.Car;
import racingcar.gamePlay.Movement;

final class RememberingState implements Car.State {
    private int forwardCount = 0;

    @Override
    public int forwardCount() {
        return forwardCount;
    }

    void save(Movement movement) {
        if (movement.isForward()) {
            increaseForwardCount();
        }
    }

    private void increaseForwardCount() {
        forwardCount += 1;
    }
}
