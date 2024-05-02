package Lesson_27;

import apcslib.Format;
/**
 * Write a description of class Item here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item implements Comparable<Item> {
    public final int id;
    private int inv;
    
    public enum CompareType {
        ID,
        INV;
    }
    
    public Item(int id, int inv) {
        this.id = id;
        this.inv = inv;
    }
    
    public int getInv() {
        return inv;
    }
    
    public int getId() {
        return id;
    }
    
    public int getID() {
        return id;
    }

    @Override
    public int compareTo(Item other) {
        if(this.id < other.id) {
            return -1;
        } else if(this.id > other.id) {
            return 1;
        } else {
            return 0;
        }
    }
    
    public int compareTo(Item other, CompareType type) {
        switch(type) {
            case ID:
                return compareTo(other);
            case INV:
                if(other.getInv() < inv) {
                    return -1;
                } else if(other.getInv() > inv) {
                    return 1;
                } else {
                    return 0;
                }
            default:
                throw new UnsupportedOperationException("No valid CompareType provided");
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Item && ((Item) obj).id == id && ((Item) obj).getInv() == inv;
    }
    
    @Override
    public String toString() {
        return Format.right(id, 8) + Format.right(inv, 8);
    }
}
