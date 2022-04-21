package racingcar;

public class CarResult {
    private final ForwardCount forwardCount;

    public CarResult(ForwardCount forwardCount) {
        this.forwardCount = forwardCount;
    }

    public ForwardCount forwardCount() {
        return forwardCount;
    }
}
