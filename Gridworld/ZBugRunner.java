package Gridworld;

import info.gridworld.actor.ActorWorld;

public class ZBugRunner {
    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        world.add(new ZBug());
        world.show();
    }
}
