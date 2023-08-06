/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuestionOne;

/**
 *
 * @author Jakob
 */
public class SnakeLocations {

    public int x;
    public int y;

    public SnakeLocations(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "( " + this.x + ", " + this.y + " )";
    }
}
