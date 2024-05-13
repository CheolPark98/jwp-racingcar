package racingcar.validator;

public class CarNameValidator extends Validator {
    private static final Integer CAR_NAME_LENGTH=5;

    @Override
    public void validate(String carName) throws IllegalArgumentException {
        validateCarNameLength(carName);
    }

    private void validateCarNameLength(String carName) {

        if (carName.length() > CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_CAR_NAME_LENGTH.getMessage());
        }
    }
}
