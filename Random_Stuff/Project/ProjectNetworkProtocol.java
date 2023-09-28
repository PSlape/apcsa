package Random_Stuff.Project;

import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * Write a description of class ProjectNetworkProtocol here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProjectNetworkProtocol {
    
    public ProjectNetworkProtocol() {}
    
}

record PlayerData(ArrayList<Integer> ids, ArrayList<Point2D> newPositions, ArrayList<Integer> health) {
    public PlayerData {
        if(ids.size() != newPositions.size() || ids.size() != health.size()) {
            throw new IllegalArgumentException("PlayerData arrays must be of the same size");
        }
    }
}
record ProcessedData(PlayerData players) {}