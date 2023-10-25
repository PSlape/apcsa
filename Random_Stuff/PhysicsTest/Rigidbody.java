package Random_Stuff.PhysicsTest;

import java.util.ArrayList;

/**
 * Rigidbody for a custom physics engine.
 * 
 * @author Peyton Slape
 * @version 1.0
 */

public class Rigidbody {
    private final ArrayList<Pair> points;

    /**
      * Creates a rigidbody based off an array of coordinate pairs
      *
      * @param inPoints The points of the new rigidbody
      *
    */
    public Rigidbody(Pair... inPoints) {
        points = new ArrayList<Pair>();

        for(Pair point : inPoints) {
            points.add(point);
        }
    }
  
    /**
      * Creates a rigidbody based off of an ArrayList of coordinate pairs
      *
      * @param inPoints The points of the new rigidbody
      *
    */
    public Rigidbody(ArrayList<Pair> inPoints) {
        points = new ArrayList<Pair>();

        for(Pair point : inPoints) {
            points.add(point);
        }
    }


    /**
      * Creates a rigidbody based off of another rigidbody.
      *
      * @param rigidbody The rigidbody to copy
      *
    */
    public Rigidbody(Rigidbody rigidbody) {
        points = new ArrayList<Pair>();

        for(Pair point : rigidbody.points()) {
            points.add(point);
        }
    }

    /**
      * Calculates the distance between two points.
      *
      * @param p1 The first pair to check the distance between.
      * @param p2 The second pair to check the distance between.
      *
      * @return The distance between the two points.
      *
    */
    public static float calculateDistance(Pair p1, Pair p2) {
      return (float) Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
    }
  
    /**
      * Retrieves the points ArrayList
      *
      * @return The ArrayList of points in the rigidbody
    */
    public ArrayList<Pair> points() {
        return points;
    }
  public void mesh() {
    for(Pair point : points) {
      
    }
  }
}
