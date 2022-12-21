package racingGame.com.matrix.matrixObstacles;

import racingGame.com.GameContext;
import racingGame.com.Renderable;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class MatrixObstacle implements Renderable {
    private final String color = "RED";
    private final int[] COORDINATE_RANDOM_CHOICE = {4, 24};
    private double y;
    private int x;
    private final ArrayList<MatrixObstacle> obstaclesList = new ArrayList<>();
    private int[][] matrixTree;
    private int[][] matrixCar;


    public MatrixObstacle() {
        this.x = COORDINATE_RANDOM_CHOICE[ThreadLocalRandom.current().nextInt(0, 2)];
        this.y = ThreadLocalRandom.current().nextInt(1, 3);
    }

    public void setY(int y) {
        this.y = y;
    }

    public ArrayList<MatrixObstacle> getObstaclesList() {
        return obstaclesList;
    }

    public int[][] getMatrixTree() {
        matrixTree = new int[][]{
                {0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 2, 2, 2, 2, 0, 0, 0, 0},
                {0, 0, 0, 2, 2, 2, 2, 2, 2, 0, 0, 0},
                {0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0},
                {0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0},
        };
        return matrixTree;

    }

    public int[][] getMatrixCar() {
        matrixCar = new int[][]{
                {0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 2, 2, 2, 2, 0, 0, 0, 0},
                {0, 0, 0, 2, 2, 2, 2, 2, 2, 0, 0, 0},
                {0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0},
                {0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0},
        };
        return matrixCar;
    }

    public void moveDown(GameContext gameContext) {
        this.y = this.y + gameContext.getPlayer().getLevel().getDiff().getSpeed();
    }

    public void MatrixMoveDown(GameContext gameContext) {
        for (MatrixObstacle obstacle : getObstaclesList())
            obstacle.moveDown(gameContext);
    }

    public void changeOfCoordinates(GameContext gameContext) {
        if (getObstaclesList().get(0).getY() > gameContext.getRoad().getHEIGHT()) {
            getObstaclesList().set(0, new MatrixObstacle());
        } else if (getObstaclesList().get(1).getY() > gameContext.getRoad().getHEIGHT()) {
            getObstaclesList().set(1, new MatrixObstacle());
        } else if (getObstaclesList().get(0).getX() == getObstaclesList().get(1).getX()) {
            getObstaclesList().get(0).setX(44);
            getObstaclesList().get(1).setX(4);
        }
    }

    public String getColor() {
        return color;
    }

    public double getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setMatrixTree(int[][] matrixTree) {
        this.matrixTree = matrixTree;
    }

    public void setMatrixCar(int[][] matrixCar) {
        this.matrixCar = matrixCar;
    }

    @Override
    public int[][] getMatrix() {
        return getMatrixCar();
    }

}


