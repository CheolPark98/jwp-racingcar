package racingcar.validator;

public enum ExceptionMessage {
    INVALID_CAR_NAME_LENGTH("이름의 길이는 5이하여야 합니다."),
    INVALID_RACING_NUMBER("경주 횟수는 정수여야합나디ㅏ.");

    private final String message;
    private static final String BASE_MESSAGE="[ERROR] %s";
    ExceptionMessage(String message){
        this.message=String.format(BASE_MESSAGE,message);
    }

    public String getMessage() {
        return message;
    }
}
