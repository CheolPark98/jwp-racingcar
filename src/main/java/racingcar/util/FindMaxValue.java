package racingcar.util;

import racingcar.domain.RacingCar;

import java.util.Map;

public class FindMaxValue {
    public int find(Map<RacingCar, Integer> cars){
        int max=0;
        for (Integer value : cars.values()) {
            max=Math.max(max,value);
        }
        return max;
    }
}
