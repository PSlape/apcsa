package Gridworld;

import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;
import java.awt.Color;

public class BetterBug extends Bug {
    void turn(int deg) {
        int current = this.getDirection();
        
        this.setDirection((current > 0) ? current + deg : current - deg); 
    }
    void turnLeft(int deg) {
        this.setDirection(this.getDirection() - deg);
    }
    void turnRight(int deg) {
        this.setDirection(this.getDirection() + deg);
    }
    void flip() {
        int current = this.getDirection();
        this.setDirection((current >= 180) ? current - 180 : current + 180);
    }
    void setColor(int r, int g, int b) {
        this.setColor(new Color(r, g, b));
    }
    void moveTo(int x, int y) {
        this.moveTo(new Location(x, y));
    }
    void setNorth() {
        this.setDirection(Location.NORTH);
    }
    void setSouth() {
        this.setDirection(Location.SOUTH);
    }
    void setEast() {
        this.setDirection(Location.EAST);
    }
    void setWest() {
        this.setDirection(Location.WEST);
    }
    boolean canMove(int deg) {
        int current = this.getDirection();
        boolean toReturn;
        this.setDirection(deg);
        if(canMove()) {
            toReturn = true;
        } else {
            toReturn = false;
        }
        this.setDirection(current);
        return toReturn;
    }
}