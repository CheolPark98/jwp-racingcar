package racingcar.validator;

public class RaceNumberValidator extends Validator{

    @Override
    public void validate(String input) throws IllegalArgumentException {
        validateInt(input);
    }

    private void validateInt(String input) {
        try {
            Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_RACING_NUMBER.getMessage());
        }

    }

}
