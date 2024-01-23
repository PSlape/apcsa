package Lesson_21;

import chn.util.ConsoleIO;
/*
 * Name: Peyton Slape
 *
 */
public class KnightRunner
{
    public static void main(String[] args) {
        
        System.out.print("Do you want to run 21.1 or 21.2: ");
        double in = new ConsoleIO().readDouble();
        KnightTour tour = new KnightTour(
            in == 21.1 ? true : false
        );
        boolean canRun = true;
        
        System.out.println("\n\n\n");
        while(canRun) {
            canRun = tour.step();
        }
        
        tour.printResults();
    }
}
