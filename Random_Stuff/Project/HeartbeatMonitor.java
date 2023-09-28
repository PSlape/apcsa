package Random_Stuff.Project;

import java.io.*;


/**
 * Write a description of class HeartbeatMonitor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HeartbeatMonitor extends Thread {
    private DataInputStream input;
    private DataOutputStream output;
    
    public HeartbeatMonitor(DataInputStream in, DataOutputStream out) {
        input = in;
        output = out;
    }
    
    @Override
    public void run() {
        double startTime = System.currentTimeMillis();
        try {
            if(this.isInterrupted()) {
                this.start();
            }
            output.write(-1);
            if(input.readInt() == -1) {
                System.out.println("Ping: " + (startTime - System.currentTimeMillis()));
            }
        } catch(IOException ex) {
            System.out.println("Ping not successful");
            this.interrupt();
        }
    }
}
