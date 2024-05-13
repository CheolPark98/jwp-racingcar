package racingcar.dto;

import racingcar.domain.RacingCar;

import java.util.List;

public class RacingResponseDto {
    private final String winners;
    private final List<RacingCar> racingCars;

    public RacingResponseDto(String winners, List<RacingCar> racingCars) {
        this.winners = winners;
        this.racingCars = racingCars;
    }


    public RacingResponseDto(List<String> winners, List<RacingCar> racingCars) {
        this.winners = String.join(",",winners);
        this.racingCars = racingCars;
    }

    public String getWinners() {
        return winners;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
