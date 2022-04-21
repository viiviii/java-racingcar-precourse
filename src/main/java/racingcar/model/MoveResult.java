package racingcar.model;

public class MoveResult {
    private final CarName carName;
    private final ForwardCount forwardCount;

    public MoveResult(CarName carName, ForwardCount forwardCount) {
        this.carName = carName;
        this.forwardCount = forwardCount;
    }

    public ForwardCount forwardCount() {
        return forwardCount;
    }

    public CarName carName() {
        return carName;
    }
}
