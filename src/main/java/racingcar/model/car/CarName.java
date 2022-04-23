package racingcar.model.car;

public final class CarName {
    private final String value;

    public CarName(String carName) {
        validateLength(carName);
        this.value = carName;
    }

    private void validateLength(String carName) {
        final int MAX_LENGTH = 5;
        if (carName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public String get() {
        return value;
    }
}
