package Gridworld.AntFarm;

/**
 * Cake.java  05/10/07
 *
 * @author - Jane Doe
 * @author - Period n
 * @author - Id nnnnnnn
 *
 * @author - I received help from ...
 *
 */

/**
 * A <code>Cake</code> sits around and waits for a
 * <code>WorkerAnt</code> to get food from it.
 * It does not act.
 */
public class Cake extends Food
{
    /** The size of a bite */
    private static final int BITE = 2;

    /**
     * Constructs a <code>Cake</code> actor.  The Cake.gif is
     * displayed for this actor without tinting.
     */
    public Cake() {
        super(BITE);
    }
}
