package Daily;

import java.util.ArrayList;
import java.awt.geom.Point2D;

public record PlayerData(ArrayList<Integer> ids, ArrayList<Point2D> newPositions, ArrayList<Integer> health) {
    public PlayerData {
        if(ids.size() != newPositions.size() || ids.size() != health.size()) {
            throw new IllegalArgumentException("PlayerData arrays must be of the same size");
        }
    }
}