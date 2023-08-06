/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuestionOne;

import static java.lang.Math.abs;
import java.util.Random;

/**
 *
 * @author Jakob
 */
public class RandomLocations {

    Random rand = new Random();
    public int x = abs(rand.nextInt() % 20);
    public int y = abs(rand.nextInt() % 20);

    public Character c = (char) (rand.nextInt(26) + 'A');

    public boolean equals(RandomLocations other) {
        return (this.x == other.x && this.y == other.y);
    }

    public int hashCode() {
        return this.x * this.y;
    }

}
