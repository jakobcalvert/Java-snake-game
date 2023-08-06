/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuestionOne;

/**
 *
 * @author Jakob
 */
public class Snake {

    public LinkedList<SnakeLocations> SnakeLoc = new LinkedList<>();
    public LinkedList<Character> snake = new LinkedList<>();
    public SnakeLocations snakeHead;

    public Snake() {
        this.snakeHead = new SnakeLocations(9, 10);
        snake.add('A');
        snake.add('B');
        snake.add('C');
        snake.add('D');
        snake.add('E');
        snake.add('F');
        snake.add('G');
        snake.add('H');

        SnakeLoc.add(this.snakeHead);
        SnakeLoc.add(new SnakeLocations(10, 10));
        SnakeLoc.add(new SnakeLocations(11, 10));
        SnakeLoc.add(new SnakeLocations(12, 10));
        SnakeLoc.add(new SnakeLocations(13, 10));
        SnakeLoc.add(new SnakeLocations(14, 10));
        SnakeLoc.add(new SnakeLocations(15, 10));
        SnakeLoc.add(new SnakeLocations(16, 10));
        SnakeLoc.add(new SnakeLocations(17, 10));
        SnakeLoc.add(new SnakeLocations(18, 10));

    }

    public void snakeRemove(int index) {
        if (index + 1 >= this.snake.size) {

            snake.removeFromTail();
        } else {
            snake.removeNode(index);
        }
        SnakeLoc.removeFromTail();

    }

    public void SnakeMove(int direction) {
        switch (direction) {
            case 0:

                snakeMove(1, 0);
                break;
            case 1:
                snakeMove(-1, 0);
                break;
            case 2:
                snakeMove(0, 1);
                break;
            case 3:
                snakeMove(0, -1);
                break;
            default:
                break;

        }
    }

    private void snakeMove(int x, int y) {
        this.snakeHead = new SnakeLocations(this.snakeHead.x + x, this.snakeHead.y + y);
        this.SnakeLoc.addAtHead(new Node(this.snakeHead));
        this.SnakeLoc.removeFromTail();
    }

    public int getSize() {
        return this.snake.size;
    }

}
