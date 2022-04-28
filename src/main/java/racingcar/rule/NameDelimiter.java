package racingcar.rule;

import java.util.ArrayList;
import java.util.List;

public class NameDelimiter {

    public List<Name> delimit(String model) {
        final String[] splitNames = splitByNameDelimiter(model);
        return mapNames(splitNames);
    }

    private String[] splitByNameDelimiter(String model) {
        final String CAR_NAME_DELIMITER = ",";
        return model.split(CAR_NAME_DELIMITER);
    }

    private List<Name> mapNames(String[] splitNames) {
        final List<Name> names = new ArrayList<>();
        for (String splitName : splitNames) {
            names.add(new Name(splitName));
        }
        return names;
    }
}
