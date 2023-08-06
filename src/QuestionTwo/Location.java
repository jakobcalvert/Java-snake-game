/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuestionTwo;

/**
 *
 * @author Jakob
 */
public class Location {

    public int x;
    public int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public boolean equals(Location location) {
        return (this.x == location.x && this.y == location.y);
    }
}
