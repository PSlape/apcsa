package Lesson_21;

import chn.util.FileInput;
import java.util.ArrayList;
import java.awt.Point;
import chn.util.ConsoleIO;

import java.util.concurrent.*;

/*
 * Name: Peyton Slape
 * Date: 1/19/24
 * Purpose: Practice with 2d arrays
 * Description: 2d bacteria simulation
 */
public class LifeContainer {
    public static final int TIME_CAN_RUN_MS = 5000;
    
    public static void main(String[] args) {
        FileInput input = new FileInput("C:\\Users\\Mudzg\\Downloads\\life100.txt");
        ConsoleIO cons = new ConsoleIO();
        
        
        
        int end = input.readInt();
        ArrayList<Point> points = new ArrayList<Point>(end);
        for(int i = 0; i < end; i++) {
            points.add(new Point(input.readInt()-1, input.readInt()-1));
        }
        
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<RunnerStorage> future = executor.submit(new LifeRunner(points));
        RunnerStorage runnerOut = new RunnerStorage(0);
        RunnerStorage previous = new RunnerStorage(0);
        RunnerStorage prevPrevious = new RunnerStorage(0);
        Life life = new Life(points);
        int iterations = 0;
        
        for(int i = 0; i < 5; i++) {
            life.step();
        }
        System.out.println(life);
        
        System.exit(0);
        while(true) {
            life.step();
            runnerOut = new RunnerStorage(life, ++iterations);
            System.out.println(runnerOut);
            if(runnerOut.equals(previous) || runnerOut.equals(prevPrevious)) break;
            previous = runnerOut;
            prevPrevious = previous;
            /*
            try {
                runnerOut = future.get(TIME_CAN_RUN_MS, TimeUnit.MILLISECONDS);
                System.out.println(runnerOut);
                if(previous.equals(runnerOut)) break;
                previous = runnerOut;
            } catch(TimeoutException e) {
                future.cancel(true);
                System.out.println("\n\nTerminated, final iteration was " + runnerOut.iterations);
                System.exit(0);
            } catch(Exception ex) {
                ex.printStackTrace();
                System.out.println("A fatal error has occoured.");
                System.exit(0);
            }
            */
        }
        
        System.out.println("The simulation has stagnated at: " + runnerOut.iterations);
    }
    
    private static class LifeRunner implements Callable<RunnerStorage> {
        private transient final Life life;
        public transient int iterations = 0;
        
        public LifeRunner(ArrayList<Point> points) {
            super();
            life = new Life(points);
        }
        
        public RunnerStorage call() {
            life.step();
            iterations++;
            return new RunnerStorage(life, iterations);
        }
    }
    
    private static class RunnerStorage {
        public String lifeToString;
        public int iterations;
        
        public RunnerStorage(Life life, int iterations) {
            if(life != null) {
                lifeToString = life.toString();
            } else {
                lifeToString = "";
            }
            
            this.iterations = iterations;
        }
        
        public RunnerStorage(int iterations) {
            lifeToString = "";
            this.iterations = iterations;
        }
        
        public String toString() {
            return "Iteration " + iterations + "\n\n" + lifeToString + "\n\n\n";
        }
        
        public boolean equals(RunnerStorage storage) {
            return (storage.iterations == iterations) && (storage.lifeToString.equals(lifeToString));
        }
    }
}



