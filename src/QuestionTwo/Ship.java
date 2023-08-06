//Which object have you chosen for the synchronize? Why?
//I have chosen to synchronize the moving boolean static array. I have chosen this as 
//It is shared by all of the ships and is used by all of them.

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuestionTwo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jakob
 */
public class Ship implements Runnable {

    public static Boolean[] moving = new Boolean[20];
    public static final Location islandLocation = new Location(800, 300);
    public static Boolean shipMoving = false;
    public static boolean stop = false;
    public Location location;
    public int shipIndex;
    public static boolean synchronize = true;
    public static int numberOfShipsMoving = 0;

    public Ship(Location location, int index) {
        this.location = location;
        this.shipIndex = index;
        for (int i = 0; i < 20; i++) {
            moving[i] = false;
        }
    }

    @Override
    public void run() {
        if (synchronize) {
            synchronized (moving) {
                this.shipMoving = true;
                moving[this.shipIndex] = true;
                while (!this.location.equals(islandLocation) && !stop) {
                    try {
                        Thread.sleep(2);

                    } catch (InterruptedException ex) {
                        Logger.getLogger(Ship.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                    if (this.location.x > islandLocation.x) {
                        this.location.x--;
                    }

                    if (this.location.x < islandLocation.x) {
                        this.location.x++;
                    }
                    if (this.location.y > islandLocation.y) {
                        this.location.y--;
                    }
                    if (this.location.y < islandLocation.y) {
                        this.location.y++;
                    }
                }
                moving[this.shipIndex] = false;
                this.shipMoving = false;

            }
        } else {
            while (!stop) {

                if (!this.shipMoving) {
                    this.shipMoving = true;
                    moving[this.shipIndex] = true;
                    while (!this.location.equals(islandLocation)) {
                        try {
                            Thread.sleep(2);

                        } catch (InterruptedException ex) {
                            Logger.getLogger(Ship.class
                                    .getName()).log(Level.SEVERE, null, ex);
                        }
                        if (this.location.x > islandLocation.x) {
                            this.location.x--;
                        }

                        if (this.location.x < islandLocation.x) {
                            this.location.x++;
                        }
                        if (this.location.y > islandLocation.y) {
                            this.location.y--;
                        }
                        if (this.location.y < islandLocation.y) {
                            this.location.y++;
                        }
                    }
                    this.shipMoving = false;
                    moving[this.shipIndex] = false;
                }

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {

                }

            }
        }
    }

}
