package racingcar.util;

import racingcar.domain.RacingCar;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CarGenerator {

    public Map<RacingCar,Integer> generate(List<String> input){
        Map<RacingCar,Integer> cars= new LinkedHashMap<>();
        for (String carName : input) {
            cars.put(new RacingCar(carName),0);
        }
        return cars;
    }

}
