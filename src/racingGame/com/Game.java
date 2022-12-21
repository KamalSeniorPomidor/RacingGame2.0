package racingGame.com;

import racingGame.com.matrix.matrixCars.*;
import racingGame.com.matrix.matrixObstacles.MatrixObstacle;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Game {
    private final String START_TEXT = "Добро пожаловать в игру Racing";


    public Game(GameContext context) {
        context.setPlayer(createPlayer(context));
        init(context);
    }


    public Player createPlayer(GameContext context) {
        System.out.println(START_TEXT);
        System.out.println("    Создайте игрока");
        Scanner input = new Scanner(System.in);
        System.out.println("      Введите имя");
        String name = input.next();
        var player = new Player();
        player.setCar(choiceCar());
        player.setLevel(choiceLevel());
        player.setName(name);
        return player;
    }

    /**
     * Метод инициализации игры
     *
     * @param context
     */

    public void init(GameContext context) {
        context.getObstacle().getObstaclesList().add(new MatrixObstacle());
        context.getObstacle().getObstaclesList().add(new MatrixObstacle());
        Runnable run = new Runnable() {
            @Override
            public void run() {
                finishGame(context);
                context.getObstacle().changeOfCoordinates(context);
                context.getObstacle().MatrixMoveDown(context);
                Render.renderFrame(context);
                context.getPlayer().getLevel().getDiff().setDistance(context.getPlayer().getLevel().getDiff().getDistance() - 2);

            }
        };
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(run, 0, 550, TimeUnit.MILLISECONDS);
        direction(context);
        direction(context);

    }


    /**
     * Метод выбора автомобиля
     */
    private MatrixCar choiceCar() {
        System.out.println();
        System.out.println("Выберите автомобиль");
        System.out.println();
        System.out.println((""" 
                .......................
                |    1 - Бмв М5       |
                |    2 - Ваз 2107     |
                |    3 - Камаз        |
                |    4 - Ауди Q8      |
                |.....................|"""));
        System.out.println();
        Scanner input = new Scanner(System.in);
        System.out.println("Введите номер автомобиля");
        int position = input.nextInt();
        switch (position) {
            case 1 -> {
                return new BmwM5();
            }
            case 2 -> {
                return new Vaz2107();
            }
            case 3 -> {
                return new Kamaz();
            }
            case 4 -> {
                return new AudiQ8();
            }
            default -> {
                System.out.println("Введите корректный номер автомоблия");
                return choiceCar();
            }
        }
    }


    /**
     * Метод выбора уровня
     */

    private Level choiceLevel() {
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("Выберите уровень сложности");
        System.out.println();
        System.out.println(""" 
                ........................
                |    1 - Легкий        |
                |    2 - Средний       |
                |    3 - Сложный       |
                |    4 - Очень сложный |
                |......................|""");
        System.out.println();
        System.out.println("Введите номер уровня");
        int position = input.nextInt();
        switch (position) {
            case 1 -> {
                return new Level(Difficult.EASY);
            }
            case 2 -> {
                return new Level(Difficult.MEDIUM);
            }
            case 3 -> {
                return new Level(Difficult.HIGH);
            }
            case 4 -> {
                return new Level(Difficult.HARD);
            }
            default -> {
                System.out.println("Введите корректный номер автомоблия");
                return choiceLevel();
            }
        }
    }

    private void direction(GameContext context) {
        while (true) {
            Scanner input = new Scanner(System.in);
            char direction = input.next().charAt(0);
            if (direction == 'a' || direction == 'A' || direction == 'ф' || direction == 'Ф') {
                context.getPlayer().getCar().toLeft();
            } else if (direction == 'd' || direction == 'D' || direction == 'в' || direction == 'В') {
                context.getPlayer().getCar().toRight();
            }
        }
    }

    public void isTouch(GameContext context) {

    }

    public void finishGame(GameContext context) {
        Scanner sc = new Scanner(System.in);
        if (context.getPlayer().getCar().getLife() <= 0) {
            System.out.println("""
                    Вы проиграли
                     1.Начать заново
                     2.Выйти""");
            int choice = sc.nextInt();
            if (choice == 1) {
                new Game(context);
            } else if (choice == 3) {
                System.exit(1);
            } else {
                System.out.println("Ошибка , введите число от 1 до 2");
            }
        }
        if (context.getPlayer().getLevel().getDiff().getDistance() <= 0) {
            System.out.println("""
                    Поздравляю вы прошли уровень!!!
                    1.Начать заново
                    2.Выйти""");
            int choice = sc.nextInt();
            if (choice == 1) {
                new Game(context);
            } else if (choice == 3) {
                System.exit(1);
            } else {
                System.out.println("Ошибка , введите число от 1 до 2");
            }
        }
    }
}