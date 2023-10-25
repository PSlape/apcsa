package Random_Stuff.PhysicsTest;

/**
 * Write a description of class GameObject here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameObject {
    private Pair localPosition;
    private Rigidbody localRigidbody;
    
    
    public Pair position() {
        return localPosition;
    }
    
    public void position(Pair newPosition) {
        localPosition = newPosition;
    }
    
    public Rigidbody rigidbody() {
        return localRigidbody;
    }
    
}
