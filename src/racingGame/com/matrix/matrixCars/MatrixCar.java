package racingGame.com.matrix.matrixCars;

import org.fusesource.jansi.Ansi;
import racingGame.com.Drivable;
import racingGame.com.Renderable;


public abstract class MatrixCar implements Drivable, Renderable {
    private int x;
    private final int y = 38;

    private Ansi color;
    private int life;

    abstract int[][] getModelCar();


    public MatrixCar(Ansi color, int life) {
        this.x = 25;
        this.color = color;
        this.life = life;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public Ansi getColor() {
        return color;
    }

    public void setColor(Ansi color) {
        this.color = color;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;

    }

    @Override
    public int[][] getMatrix() {
        return getModelCar();
    }

    @Override
    public void toLeft() {
        if (getX() > 10) {
            setX(getX() - 20);
        }

    }

    @Override
    public void toRight() {
        if (getX() < 40) {
            setX(getX() + 20);
        }
    }
}

