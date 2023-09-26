package Lesson_11;


/**
 * Write a description of class ASCLLand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Intermediate_ASCLLand {
    private static final int[][] input = {
        {8,7,5,3,2,1,0},
        {8,5,7,3,5,7,8,1,8,7,5,1,0},
        {7,5,3,5,8,1,3,7,2,5,1,2,0},
        {3,8,6,1,5,4,5,8,7,4,8,7,0},
        {8,7,1,4,5,8,8,7,4,6,3,1,8,1,8,4,8,5,0},
    };
    
    public static void main(String[] args) {
        for(int gameNum = 0; gameNum < input.length; gameNum++) {
            Game game = new Game(41);
            for(int move = 0; move < input[gameNum].length; move++) {
                if(move % 2 == 0) {
                    game.move_player_1(input[gameNum][move]);
                } else {
                    game.move_player_2(input[gameNum][move]);
                }
            }
            
            String aPrint, bPrint;
            if(game.getPosPlayer1() == game.maxMoves) {
                aPrint = "END";
            } else {
                aPrint = Integer.toString(game.getPosPlayer1());
            }
            
            if(game.getPosPlayer2() == game.maxMoves) {
                bPrint = "END";
            } else {
                bPrint = Integer.toString(game.getPosPlayer2());
            }
            System.out.println("Output " + (gameNum + 1) + ": A-" + aPrint + ", B-" + bPrint);
        }
    }
}