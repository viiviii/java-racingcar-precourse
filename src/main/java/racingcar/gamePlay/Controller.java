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
        attemptCount.forEachRemaining(sequence -> {
            cars.move();
            view.outputRecords(cars.records());
        });
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
