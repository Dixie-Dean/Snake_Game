import auxiliary.State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Game extends JPanel implements ActionListener {

    public static State state;
    public static final int SCREEN_WIDTH = 600;
    public static final int SCREEN_HEIGHT = 600;
    public static final int UNIT_SIZE = 25;
    public static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    public static final int DELAY = 75;
    public static final int[] x = new int[GAME_UNITS];
    public static final int[] y = new int[GAME_UNITS];
    public static int bodyParts = 6;
    public static int applesEaten;
    public static int appleX;
    public static int appleY;
    char direction = 'R';
    public static Timer timer;
    private static Random random;
    private final MenuRenderer menuRenderer = new MenuRenderer();
    private final GameOverRender gameOver = new GameOverRender();
    private final GameRenderer gameRenderer = new GameRenderer();

    public Game() {
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        this.addMouseListener(new MouseInput());
        launch();
    }

    public void launch() {
        state = State.MENU;
        addApplePosition();

        timer = new Timer(DELAY, this);
        timer.start();
    }


    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        draw(graphics);
    }

    public void draw(Graphics graphics) {
        if(state == State.GAME) {
            gameRenderer.render(graphics);
        } else if (state == State.MENU) {
            menuRenderer.render(graphics);
        } else {
            gameOver.render(graphics);
        }
    }

    public static void addApplePosition() {
        appleX = random.nextInt(SCREEN_WIDTH / UNIT_SIZE) * UNIT_SIZE;
        appleY = random.nextInt(SCREEN_HEIGHT / UNIT_SIZE) * UNIT_SIZE;
    }

    public void move() {
        for (int i = bodyParts; i > 0 ; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
        }
    }

    public void checkApple() {
        if (x[0] == appleX && y[0] == appleY) {
            bodyParts++;
            applesEaten++;
            addApplePosition();
        }
    }

    public void checkCollisions() {
        for (int i = bodyParts; i > 0 ; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                state = State.LOST;
                break;
            }
        }

        if (x[0] < 0) {
            state = State.LOST;
        }

        if (x[0] > SCREEN_WIDTH) {
            state = State.LOST;
        }

        if (y[0] < 0) {
            state = State.LOST;
        }

        if (y[0] > SCREEN_HEIGHT) {
            state = State.LOST;
        }

        if (state == auxiliary.State.MENU || state == auxiliary.State.LOST) {
            timer.stop();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (state == State.GAME) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_RIGHT:
                    if (direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_LEFT:
                    if (direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction != 'U') {
                        direction = 'D';
                    }
            }
        }
    }
}
