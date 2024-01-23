package Gridworld;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

public class ZBugRunner {
    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        world.add(new Location(0,0), new ZBug());
        world.show();
    }
}
