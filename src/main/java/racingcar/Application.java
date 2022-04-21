package racingcar;

import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        Car car = new Car();
        MoveCondition moveCondition = car.move();
        outputView.printRacingPace(moveCondition);
    }
}
