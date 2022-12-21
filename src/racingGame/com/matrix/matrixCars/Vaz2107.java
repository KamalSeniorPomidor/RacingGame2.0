package racingGame.com.matrix.matrixCars;

import org.fusesource.jansi.Ansi;

public class Vaz2107 extends MatrixCar {
    int[][] car;

    public Vaz2107() {
        super(Ansi.ansi().fg(Ansi.Color.RED).a("X"), 2);
    }

    @Override
    public int[][] getModelCar() {
        car = new int[][]{
                {0, 0, 0, 3, 3, 3, 3, 0, 0, 0},
                {3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                {0, 0, 3, 3, 3, 3, 3, 3, 0, 0},
                {0, 0, 3, 3, 3, 3, 3, 3, 0, 0},
                {0, 0, 3, 3, 3, 3, 3, 3, 0, 0},
                {3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
        };
        return car;
    }
}
