package Lesson_11;

public class Game {
    Player player1, player2;
    int maxMoves;
    
    public Game(int maxMoves) {
        this.maxMoves = maxMoves;
        player1 = new Player();
        player2 = new Player();
    }
    void move_player_1(int roll) {
        if(player1.pos + roll <= maxMoves) {
            if(roll == 4 || roll == 6) {
                if(player1.pos - roll < 0) {
                    player1.setPos(0);
                } else {
                    player1.move(-roll);
                }
            } else {
                player1.move(roll);
            }
        } else {
            player1.setPos(maxMoves);
        }
    }
    void move_player_2(int roll) {
        if(player2.pos + roll <= maxMoves) {
            if(roll == 4 || roll == 6) {
                if(player2.pos - roll < 0) {
                    player2.setPos(0);
                } else {
                    player2.move(-roll);
                }
            } else {
                player2.move(roll);
            }
        } else {
            player2.setPos(maxMoves);
        }
    }
    int getPosPlayer1() {
        return player1.pos;
    }
    int getPosPlayer2() {
        return player2.pos;
    }
    private int rollDie() {
        return (int) (8.0 * Math.random() + 1.0);
    }
    void reset() {
        player1.setPos(0);
        player2.setPos(0);
    }
}