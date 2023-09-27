package Lesson_11;

public class Player {
    int pos;
    public Player() {
        pos = 0;
    }
    void move(int moveAmnt) {
        pos += moveAmnt;
    }
    void setPos(int pos) {
        this.pos = pos;
    }
}