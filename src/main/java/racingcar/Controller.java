package racingcar;

public final class Controller {
    private final View view;
    private final Car car;
    private final MyRandom myRandom;

    public Controller(View view, Car car, MyRandom myRandom) {
        this.view = view;
        this.car = car;
        this.myRandom = myRandom;
    }

    public void start() {
        int condition = myRandom.pickNumberInRage(0, 9);
        boolean moved = car.move(condition);
        view.moveResult(moved);
    }
}
