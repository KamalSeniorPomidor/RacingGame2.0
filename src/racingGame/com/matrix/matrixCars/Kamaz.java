package racingGame.com.matrix.matrixCars;

import org.fusesource.jansi.Ansi;

public class Kamaz extends MatrixCar {
    private int[][] car;

    public Kamaz() {
        super(Ansi.ansi().fg(Ansi.Color.YELLOW).a("X"), 5);
    }


    /**
     * Метод создания матрицы машины
     */
    @Override
    public int[][] getModelCar() {
        car = new int[][]{
                {0, 0, 3, 3, 3, 3, 3, 0, 0, 0},
                {0, 0, 3, 3, 3, 3, 3, 0, 0, 0},
                {3, 3, 3, 3, 3, 3, 3, 3, 3, 0},
                {3, 3, 3, 3, 3, 3, 3, 3, 3, 0},
                {3, 3, 3, 3, 3, 3, 3, 3, 3, 0},
                {3, 3, 3, 3, 3, 3, 3, 3, 3, 0},
        };
        return car;
    }
}
