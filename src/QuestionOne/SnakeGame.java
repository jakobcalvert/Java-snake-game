/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuestionOne;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Jakob
 */
public class SnakeGame extends JFrame implements Runnable, KeyListener {

    Snake snake = new Snake();
    public int direction = 1;
    ArrayList<RandomLocations> arrayOfRand = new ArrayList<>();
    RandomLocations letter = new RandomLocations();
    JLabel[][] label;
    JLabel Text;

    public SnakeGame() {
        super("Snake Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 428);
        setResizable(false);
        setVisible(true);
        setLayout(null);
        addKeyListener(this);

        for (int i = 0; i < 10; i++) {
            RandomLocations rand = new RandomLocations();
            arrayOfRand.add(rand);
        }

        label = new JLabel[20][20];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                label[i][j] = new JLabel();

                label[i][j].setSize(15, 10);
                label[i][j].setLocation(new Point(i * 20 + 4, j * 20 + 4));
                add(label[i][j]);
            }
        }
        for (int i = 0; i < arrayOfRand.size(); i++) {
            label[arrayOfRand.get(i).x][arrayOfRand.get(i).y].setText(i + "");
        }

    }

    public static void main(String[] args) {
        SnakeGame snakes = new SnakeGame();
        Thread thread = new Thread(snakes);
        thread.start();

    }

    @Override
    public void run() {
        boolean running = true;
        try {
            do {
                snake.SnakeMove(this.direction);
                label[letter.x][letter.y].setText(letter.c.toString());
                for (int i = 0; i < snake.getSize() + 2; i++) {
                    var variable = snake.SnakeLoc.getNode(i);
                    Character body = snake.snake.getData(i);
                    if (variable != null) {
                        SnakeLocations data = (SnakeLocations) variable.data;
                        if (body != null) {
                            label[data.x][data.y].setText(body.toString());
                        } else {
                            label[data.x][data.y].setText(" ");
                        }
                    } else {
                        running = false;
                    }

                }

                if (snake.snakeHead.x == letter.x && snake.snakeHead.y == letter.y) {
                    snake.snake.addInOrder(letter.c);
                    snake.SnakeLoc.add(new SnakeLocations(-1, -1));
                    letter = new RandomLocations();
                }
                for (int i = 1; i < snake.getSize(); i++) {
                    if (snake.snakeHead.x == snake.SnakeLoc.getData(i).x && snake.snakeHead.y == snake.SnakeLoc.getData(i).y) {
                        running = false;
                    }
                }
                for (int i = 0; i < arrayOfRand.size(); i++) {
                    if (snake.snakeHead.x == arrayOfRand.get(i).x && snake.snakeHead.y == arrayOfRand.get(i).y) {
                        snake.snakeRemove(i);
                        arrayOfRand.remove(i);

                        arrayOfRand.add(i, new RandomLocations());
                        label[arrayOfRand.get(i).x][arrayOfRand.get(i).y].setText(i + "");
                        break;
                    }
                }
                if (snake.snake.size == 0) {
                    running = false;
                }

                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SnakeGame.class.getName()).log(Level.SEVERE, null, ex);
                }

            } while (running);
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        setTitle("Game over - Press R to restart");
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_UP) {
            if (this.direction != 2) {
                this.direction = 3;
            }
        }
        if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
            if (this.direction != 3) {
                this.direction = 2;
            }
        }
        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
            if (this.direction != 0) {
                this.direction = 1;
            }
        }
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (this.direction != 1) {
                this.direction = 0;
            }

        }
        if (ke.getKeyCode() == KeyEvent.VK_R) {
            SnakeGame snakes = new SnakeGame();
            Thread thread = new Thread(snakes);
            thread.start();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
