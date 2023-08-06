/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuestionTwo;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Jakob
 */
//The program by default starts as syncronised
public class ShipPanel extends Canvas implements KeyListener {

    public static final int numberOfBoats = 20;
    public static ShipPanel ship;
    public static JFrame f;
    Image[] i;
    Image island;
    Image islandBoat;

    Ship[] ships = new Ship[numberOfBoats];
    Thread[] thread;

    public ShipPanel() {
        Toolkit t = Toolkit.getDefaultToolkit();

        i = new Image[numberOfBoats];
        island = t.getImage("Resources/Land.png");
        islandBoat = t.getImage("Resources/boat_land.png");
        thread = new Thread[numberOfBoats];
        for (int j = 0; j < numberOfBoats / 2; j++) {
            i[j] = t.getImage("Resources/boat.png");
            this.ships[j] = new Ship(new Location(20, 50 + 60 * j), j);
            thread[j] = new Thread(this.ships[j]);

        }
        for (int j = numberOfBoats / 2; j < numberOfBoats; j++) {
            i[j] = t.getImage("Resources/boat.png");
            this.ships[j] = new Ship(new Location(80, 50 + 60 * (j - (numberOfBoats / 2))), j);
            thread[j] = new Thread(this.ships[j]);

        }

    }

    public void paint(Graphics g) {

        g.drawImage(island, Ship.islandLocation.x, Ship.islandLocation.y, this);
        for (int j = 0; j < numberOfBoats; j++) {

            g.drawImage(i[j], this.ships[j].location.x, this.ships[j].location.y, this);
            if (this.ships[j].location.equals(Ship.islandLocation)) {
                g.drawImage(islandBoat, Ship.islandLocation.x, Ship.islandLocation.y, this);
            } else {

            }

        }
        int i = 0;
        for (int j = 0; j < numberOfBoats; j++) {
            if (Ship.moving[j]) {
                i++;
            }
        }
        if (i > 1) {
            g.setColor(Color.red);
            g.fillOval(820, 50, 50, 50);
        }

        repaint();

    }

    public static void newInstance() {

        ship = new ShipPanel();
        ship.setLocation(0, 0);
        f = new JFrame();
        f.add(ship);
        if (Ship.synchronize) {
            f.setTitle("Synchronized - Press S to toggle between modes");
        } else {
            f.setTitle("Unsynchronized - Press S to toggle between modes");
        }

        f.addKeyListener(ship);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setSize(1000, 1000);
        f.setVisible(true);
        f.setLayout(null);

        Ship.stop = false;
        for (int j = 0; j < numberOfBoats; j++) {
            ship.thread[j].start();
        }
    }

    public static void main(String[] args) {
        newInstance();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_S) {
            f.dispose();
            Ship.stop = true;

            if (Ship.synchronize) {
                Ship.synchronize = false;

                newInstance();
            } else {
                Ship.synchronize = true;

                newInstance();

            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
