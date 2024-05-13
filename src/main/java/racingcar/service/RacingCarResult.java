package racingcar.service;

import racingcar.domain.RacingCar;

import java.util.List;

public class RacingCarResult {
    private final List<String> winners;
    private final List<RacingCar> cars;
    private final int attempt;


    public RacingCarResult(List<String> winners, List<RacingCar> cars, int attempt) {
        this.winners = winners;
        this.cars = cars;
        this.attempt = attempt;
    }

    public List<String> getWinners() {
        return winners;
    }

    public List<RacingCar> getCars() {
        return cars;
    }

    public int getAttempt() {
        return attempt;
    }
}
