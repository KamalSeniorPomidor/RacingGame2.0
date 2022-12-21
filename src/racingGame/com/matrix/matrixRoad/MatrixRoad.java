package racingGame.com.matrix.matrixRoad;


import racingGame.com.Renderable;

public class MatrixRoad implements Renderable {
    private final int HEIGHT = 45;
    private final int WIDTH = 59;
    public int[][] matrixRoad = new int[HEIGHT][WIDTH];

    public MatrixRoad() {
    }


    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    @Override
    public int[][] getMatrix() {
        matrixRoad = new int[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < 30; j++) {
                matrixRoad[i][0] = 1;
                matrixRoad[i][19] = 1;
                matrixRoad[i][39] = 1;
                matrixRoad[i][58] = 1;
            }
        }
        return matrixRoad;
    }
}
