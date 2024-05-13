package racingcar.domain;

public class Position {
    private int position=0;
    public Position(){}

    public Position(int position) {
        this.position = position;
    }


    public void increase(){
        position++;
    }

    public int getPosition(){
        return position;
    }
}
