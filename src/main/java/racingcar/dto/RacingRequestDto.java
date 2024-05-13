package racingcar.dto;

public class RacingRequestDto {
    private String names;
    private int count;

    public RacingRequestDto(){}

    public RacingRequestDto(String names, int count) {
        this.names = names;
        this.count = count;
    }

    public String getNames() {
        return names;
    }

    public int getCount() {
        return count;
    }
}
