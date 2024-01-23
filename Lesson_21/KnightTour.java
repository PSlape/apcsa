package Lesson_21;
import java.util.ArrayList;
import java.awt.Point;
import java.util.Random;
import apcslib.Format;

/**
 * Write a description of class KnightTour here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class KnightTour {
   private static final Point[] translations = {
       new Point( 1, -2),
       new Point( 2, -1),
       new Point( 2,  1),
       new Point( 1,  2),
       new Point(-1,  2),
       new Point(-2,  1),
       new Point(-2, -1),
       new Point(-1, -2)
   };
   
   private final boolean isLabOne;
   
   private static final Point BOARD_DIMENSIONS = new Point(8, 8);
   
   private Point pos;
   
   private Random random;
   
   private int[][] board = new int[BOARD_DIMENSIONS.x][BOARD_DIMENSIONS.y];
   
   private int iteration;
   
   public KnightTour() {
       pos = new Point(0, 0);
       random = new Random();
       iteration = 1;
       isLabOne = false;
   }
   
   public KnightTour(boolean isOne) {
       pos = new Point(0, 0);
       random = new Random();
       iteration = 1;
       isLabOne = isOne;
   }
   
   public boolean step() {
       ArrayList<Point> moves = possibleMoves();
       
       board[pos.x][pos.y] = iteration;
       
       if(moves.size() == 0) return false;
       Point move = isLabOne ? moves.get(random.nextInt(moves.size())) : pickPoint(moves);
       pos = move;
       
       iteration++;
       return true;
   }
   
   public ArrayList<Point> possibleMoves() {
       ArrayList<Point> travel = new ArrayList<Point>();
       
       for(Point trans : translations) {
           Point translatedPoint = addPoints(pos, trans);
           try {
               if(board[translatedPoint.x][translatedPoint.y] == 0) {
                   travel.add(new Point(translatedPoint));
               }
           } catch(ArrayIndexOutOfBoundsException ex) {}
       }
       
       return travel;
   }
   
   private boolean inBounds(Point point) {
       return (point.x > 0 && point.x < board.length) && (point.y > 0 && point.y < board.length);
   }
   
   public Point addPoints(Point one, Point two) {
       return new Point(one.x + two.x, one.y + two.y);
   }
   
   public int[][] getBoard() {
       return board;
   }
   
   public void printResults() {
       for(int i = 0; i < 9; i++) {
           System.out.print(Format.right(i, 4));
       }
       System.out.println();
       
       for(int line = 1; line < 9; line++) {
           System.out.print(Format.right(line, 4));
           for(int ind : board[line-1]) {
               System.out.print(Format.right(ind, 4));
           }
           System.out.println();
       }
       
       System.out.println("\n\nThe horse moved " + iteration + " times.");
   }
   
   public Point pickPoint(ArrayList<Point> points) {
       Point bestOption = points.get(0);
       int bestScore = 0;
       for(Point current : points) {
           int score = 0;
           
           switch(current.x) {
                case 0,7:
                   switch(current.y) {
                       case 0, 7:
                           score = 2;
                           break;
                       case 1, 6:
                           score = 3;
                           break;
                       case 2, 3, 4, 5:
                           score = 4;
                           break;
      
                    }
                    break;
                case 1,6:
                    switch(current.y) {
                       case 0, 7:
                           score = 3;
                           break;
                       case 1, 6:
                           score = 4;
                           break;
                       case 2, 3, 4, 5:
                           score = 6;
                           break;
      
                    }
                    break;
                case 2,3,4,5:
                    switch(current.y) {
                       case 0, 7:
                           score = 4;
                           break;
                       case 1, 6:
                           score = 6;
                           break;
                       case 2, 3, 4, 5:
                           score = 8;
                           break;
      
                    }
                    break;
           }
           
           if(score > bestScore) {
               bestOption = current;
               bestScore = score;
           }
       }
       return bestOption;
   }
}
