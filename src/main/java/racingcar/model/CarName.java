package racingcar.model;

public class CarName {
    private final String carName;

    public CarName(String carName) {
        validateLength(carName);
        this.carName = carName;
    }

    private void validateLength(String carName) {
        final int MAX_LENGTH = 5;
        if (carName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public String get() {
        return carName;
    }
}
