package racingcar.domain;

public class RacingCar {
    private final String name;
    private final Position position;
    public static final int MOVE_LOWER_BOUND=4;
    public RacingCar(String name) {
        this.name = name;this.position= new Position();
    }

    public RacingCar(String name,int position) {
        this.name = name;this.position= new Position(position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position.getPosition();
    }
    public void go(int number){
        if (number>=MOVE_LOWER_BOUND){
            position.increase();
        }
    }
}
