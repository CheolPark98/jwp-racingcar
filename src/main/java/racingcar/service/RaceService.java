package racingcar.service;

import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.stereotype.Service;
import racingcar.domain.RacingCar;
import racingcar.dto.RacingResponseDto;
import racingcar.validator.CarNameValidator;
import racingcar.validator.RaceNumberValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Service
public class RaceService {

    public List<RacingCar> carInit(String names){
        CarNameValidator carNameValidator = new CarNameValidator();
        List<String> carNames = new ArrayList<>(List.of(names.split(",")));
        List<RacingCar> cars= new ArrayList<>();
        for (String carName : carNames) {
            carNameValidator.validate(carName);
            cars.add(new RacingCar(carName));
        }
        return cars;
    }

    public RacingCarResult race(List<RacingCar> cars , int count){
        //new RaceNumberValidator().validate(count);
        System.out.println("실행결과");
        for (int i=0; count>i;i++){
            carGo(cars);
        }
        int maxPosition=getMaxPosition(cars);

        List<String> winners = getWinners(cars, maxPosition);

        return new RacingCarResult(winners,cars,count);
    }

    private List<String> getWinners(List<RacingCar> cars, int maxPosition) {
        List<String> winners = new ArrayList<>();

        for (RacingCar car : cars) {
            if (car.getPosition()== maxPosition){
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public void carGo (List<RacingCar> cars){
        Random random = new Random();
        for (RacingCar racingCar : cars) {
             racingCar.go(random.nextInt(10));
        }
    }

    public int getMaxPosition(List<RacingCar> cars){
        return cars.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElse(0);
    }

}
