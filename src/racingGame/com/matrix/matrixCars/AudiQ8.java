package racingGame.com.matrix.matrixCars;


import org.fusesource.jansi.Ansi;

import static org.fusesource.jansi.Ansi.ansi;

public class AudiQ8 extends MatrixCar {
    int[][] car;

    public AudiQ8() {
        super(Ansi.ansi().fg(Ansi.Color.BLUE).a("X"), 3);
    }

    /**
     * Метод создания матрицы машины
     */
    @Override
    public int[][] getModelCar() {
        car = new int[][]{
                {3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                {3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                {0, 0, 0, 3, 3, 3, 3, 0, 0, 0},
                {0, 0, 0, 3, 3, 3, 3, 0, 0, 0},
                {0, 0, 0, 3, 3, 3, 3, 0, 0, 0},
                {3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
        };
        return car;
    }

}
