package racingcar.model.car;

final class Name {
    private final String value;

    Name(String name) {
        validateLength(name);
        this.value = name;
    }

    private void validateLength(String name) {
        final int MAX_LENGTH = 5;
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    String get() {
        return value;
    }
}
