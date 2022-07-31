package racingcar.gamePlay;

import java.util.List;

public final class Controller {
    private final View view;
    private final CarFactory carFactory;

    public Controller(View view, CarFactory carFactory) {
        this.view = view;
        this.carFactory = carFactory;
    }

    public void play() {
        final List<Car> cars = inputCars();
        final AttemptCount attemptCount = inputAttemptCount();
        attemptCount.forEachRemaining(index -> moves(cars));
    }

    private void moves(List<Car> cars) {
        for (Car car : cars) {
            car.move();
            view.outputMoveState(car.name(), car.state());
        }
    }

    private List<Car> inputCars() {
        final List<String> carNames = view.inputCarNames();
        return carFactory.createCars(carNames);
    }

    private AttemptCount inputAttemptCount() {
        final int attemptCount = view.inputAttemptCount();
        return new AttemptCount(attemptCount);
    }
}
