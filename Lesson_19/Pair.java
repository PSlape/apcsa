package Lesson_19;


/**
 * Write a description of class Pair here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Pair {
    public transient int x, y;
    
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public boolean equals(Pair pair) {
        return pair.x == x && pair.y == y;
    }
    
    public void add(Pair pair) {
        x += pair.x;
        y += pair.y;
    }
}
