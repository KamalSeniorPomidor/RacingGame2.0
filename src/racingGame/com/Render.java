package racingGame.com;

import org.fusesource.jansi.Ansi;
import racingGame.com.matrix.matrixObstacles.MatrixObstacle;

import java.io.IOException;
import java.util.ArrayList;

import static org.fusesource.jansi.Ansi.ansi;

public class Render {


    public Render() {
    }


    public static void printCarToMatrix(Player playerCar, int[][] matrixRoad, GameContext context) {
        int tempX = context.getPlayer().getCar().getX();
        int tempY = context.getPlayer().getCar().getY();
        int[][] carMatrix = context.getPlayer().getCar().getMatrix();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 10; j++) {
                if (tempY + i >= context.getRoad().getHEIGHT() || tempX + j >= context.getRoad().getWIDTH())
                    continue;
                if (carMatrix[i][j] == 3) {
                    matrixRoad[tempY + i][tempX + j] = 3;
                }
            }
        }

    }

    public static void printObstacleToMatrix(ArrayList<MatrixObstacle> obstacles, int[][] matrix, GameContext context) {
        boolean isTouch = false;
        for (int i = 0; i < obstacles.size(); i++) {
            int tempX = context.getObstacle().getObstaclesList().get(i).getX();
            int tempY = (int) context.getObstacle().getObstaclesList().get(i).getY();
            int[][] obstacleMatrix = context.getObstacle().getMatrix();
            for (int k = 0; k < 9; k++) {
                for (int j = 0; j < 12; j++) {
                    if (tempY + k >= context.getRoad().getHEIGHT() || tempX + j >= context.getRoad().getWIDTH())
                        continue;
                    if (obstacleMatrix[k][j] == 2) {
                        if (matrix[tempY + k][tempX + j] == 3) {
                            context.getObstacle().getObstaclesList().set(i, new MatrixObstacle());
                            isTouch = true;
                        } else {
                            matrix[tempY + k][tempX + j] = 2;
                        }

                    } else if (isTouch) {
                        isTouch = false;
                        context.getPlayer().getCar().setLife(context.getPlayer().getCar().getLife() - 1);
                    }
                }
            }
        }
        }


        public static void renderFrame (GameContext context){
            int[][] matrix = context.getRoad().getMatrix();
            printCarToMatrix(new Player(), matrix, context);
            printObstacleToMatrix(context.getObstacle().getObstaclesList(), matrix, context);
            System.out.println("--------------------------------------------------------------");
            for (int i = 0; i < context.getRoad().getMatrix().length; i++) {
                for (int j = 0; j < context.getRoad().getMatrix()[0].length; j++) {
                    if (matrix[i][j] == 1) {
                        System.out.print(ansi().fg(Ansi.Color.CYAN).a("|"));
                    } else if (matrix[i][j] == 3) {
                        System.out.print(context.getPlayer().getCar().getColor());
                    } else if (matrix[i][j] == 2) {
                        System.out.print(ansi().fg(Ansi.Color.GREEN).a("#"));
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
            System.out.println("До финиша " + context.getPlayer().getLevel().getDiff().getDistance() + "М");
            System.out.println("--------------------------------------------------------------");
            System.out.println("|||||||     direction:   A - LEFT , D - RIGHT  life: " + context.getPlayer().getCar().getLife());
            System.out.println("--------------------------------------------------------------");
        }

        /**
         * Метод очистки командной строки
         */
        private static void clearCmd () {
            try {
                if (System.getProperty("os.name").contains("Windows"))
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                else
                    Runtime.getRuntime().exec("clear");
            } catch (IOException | InterruptedException ex) {
            }
        }
    }
