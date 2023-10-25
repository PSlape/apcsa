package Random_Stuff.PhysicsTest;


/**
 * Coordinate pair system for a custom physics engine.
 *
 * @author Peyton Slape
 * @version 1
 */
public class Pair {
    double x, y;

    /**
      * Creates a Pair object with integer precision
      *
      * @param x The x-coordinate of the new pair.
      * @param y The y-coordinate of the new pair.
      *
    */
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
      * Creates a Pair object with double precision.
      *
      * @param x The x-coordinate of the new pair.
      * @param y The y-coordinate of the new pair.
      *
    */
    public Pair(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
      * Creates a Pair object with float precision.
      *
      * @param x The x-coordinate of the new pair.
      * @param y The y-coordinate of the new pair.
      *
    */
    public Pair(float x, float y) {
        this.x = x;
        this.y = y;
    }
}
