package racingcar;

import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Car car = new Car();
        MoveCondition run = car.run();
        OutputView outputView = new OutputView();
        outputView.printRacingPace(run);
    }
}
