package racingcar.gamePlay;

import java.util.List;

public final class Controller {
    private final View view;
    private final CarFactory carFactory;

    public Controller(View view, CarFactory carFactory) {
        this.view = view;
        this.carFactory = carFactory;
    }

    public void start() {
        final Cars cars = inputCars();
        final AttemptCount attemptCount = inputAttemptCount();
        final Result result = attemptCount.move(cars);
        view.outputResult(result);
    }

    private Cars inputCars() {
        final List<String> carNames = view.inputCarNames();
        return carFactory.createCars(carNames);
    }

    private AttemptCount inputAttemptCount() {
        final int attemptCount = view.inputAttemptCount();
        return new AttemptCount(attemptCount);
    }
}
