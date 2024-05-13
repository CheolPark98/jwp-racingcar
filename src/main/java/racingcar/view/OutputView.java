package racingcar.view;

import racingcar.domain.RacingCar;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class OutputView {
    private static final String RACING_MARK="-";
    private static final String WINNER_MESSAGE="최종 우승자 : ";
    public void printRace(Map<RacingCar, Integer> cars){
        for (RacingCar racingCar : cars.keySet()) {
            System.out.print(racingCar.getName()+" : ");
            for (int i=0; cars.get(racingCar)>i; i++){
                System.out.print(RACING_MARK);
            }
            System.out.println();
        }
    }

    public void printResult(List<String> winners){
        System.out.print(WINNER_MESSAGE);
        StringJoiner joiner = new StringJoiner(", ");
        for (String winner : winners) {
            joiner.add(winner);
        }
        System.out.println(joiner.toString());
    }
}
