package racingGame.com;

import racingGame.com.matrix.matrixRoad.MatrixRoad;
import racingGame.com.matrix.matrixObstacles.MatrixObstacle;

public class GameContext {
    private MatrixRoad road = new MatrixRoad();
    private MatrixObstacle obstacle = new MatrixObstacle();
    private Player player = new Player();

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }


    public MatrixRoad getRoad() {
        return road;
    }

    public void setRoad(MatrixRoad road) {
        this.road = road;
    }

    public MatrixObstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(MatrixObstacle obstacle) {
        this.obstacle = obstacle;
    }

}
