package racingcar.gamePlay;

import java.util.List;

public final class Controller<T extends Movable & Car> {
    private final View view;
    private final CarFactory<T> carFactory;

    public Controller(View view, CarFactory<T> carFactory) {
        this.view = view;
        this.carFactory = carFactory;
    }

    public void play() {
        final List<T> cars = inputRacingCars();
        final AttemptCount attemptCount = inputAttemptCount();
        attemptCount.forEachRemaining(index -> moves(cars));
    }

    private List<T> inputRacingCars() {
        final List<String> carNames = view.inputCarNames();
        return carFactory.create(carNames);
    }

    private AttemptCount inputAttemptCount() {
        final int attemptCount = view.inputAttemptCount();
        return new AttemptCount(attemptCount);
    }

    private void moves(List<T> cars) {
        for (T car : cars) {
            car.move();
            view.outputMovingState(car);
        }
    }
}
