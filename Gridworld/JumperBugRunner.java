package Gridworld;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.actor.Rock;

/**
 * Write a description of class JumperBugRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class JumperBugRunner {
    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        world.addOccupantClass("JumperBug");
        world.addOccupantClass("Rock");
        world.add(new Location(3, 4), new Rock());
        world.add(new Location(4, 4), new JumperBug());
        world.show();
    }
}
