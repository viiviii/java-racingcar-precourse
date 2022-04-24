package racingcar.model.car;

final class Name {
    private final String value;

    Name(String name) {
        final String trimName = name.trim();
        validateMinLength(trimName);
        validateMaxLength(trimName);
        this.value = trimName;
    }

    private void validateMinLength(String name) {
        final int MIN_LENGTH = 1;
        if (name.length() < MIN_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateMaxLength(String name) {
        final int MAX_LENGTH = 5;
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    String get() {
        return value;
    }
}
