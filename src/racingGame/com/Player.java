package racingGame.com;

import racingGame.com.matrix.matrixCars.MatrixCar;

public class Player {
    private String name;
    private Level level;
    private MatrixCar car;

    public Player() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }


    public MatrixCar getCar() {
        return car;
    }

    public void setCar(MatrixCar car) {
        this.car = car;
    }

}
