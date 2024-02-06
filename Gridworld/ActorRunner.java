package Gridworld;

import info.gridworld.actor.*;

/**
 * Write a description of class ActorRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ActorRunner {
    public static void main() {
        ActorWorld world = new ActorWorld();
        Actor act = new Actor();
        world.add(act);
        act.removeSelfFromGrid();
        world.add(act);
        world.show();
    }
}
