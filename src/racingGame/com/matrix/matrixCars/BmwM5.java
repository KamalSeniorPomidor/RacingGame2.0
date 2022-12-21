package racingGame.com.matrix.matrixCars;

import org.fusesource.jansi.Ansi;

public class BmwM5 extends MatrixCar {
    int[][] car;

    public BmwM5() {
        super(Ansi.ansi().fg(Ansi.Color.MAGENTA).a("X"), 1);
    }

    /**
     * Метод создания матрицы машины
     */
    @Override
    public int[][] getModelCar() {
        car = new int[][]{
                {3, 3, 3, 0, 0, 0, 0, 3, 3, 3},
                {0, 0, 3, 3, 3, 3, 3, 3, 0, 0},
                {0, 0, 3, 3, 3, 3, 3, 3, 0, 0},
                {0, 0, 3, 3, 3, 3, 3, 3, 0, 0},
                {0, 3, 3, 3, 3, 3, 3, 3, 3, 0},
                {3, 3, 3, 0, 0, 0, 0, 3, 3, 3},
        };
        return car;
    }
}

