package CSAClasses;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.StreamTokenizer;
import java.io.IOException;


/**
 * A console for input using BufferedReader and StringTokenizer
 *
 * @author Peyton Slape
 * @version 11/08/23
 */

public class Console {
    private final BufferedReader in;
    private StringTokenizer tokenizer;
    
    public Console() {
        in = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public String readLine() {
        try {
            return in.readLine();
        } catch(IOException io) {
            io.printStackTrace();
            System.exit(0);
        } catch(Exception ex) {
            System.out.println("An unexpected error occurred");
            ex.printStackTrace();
            System.exit(0);
        }
        return "";
    }
    
    public String readToken() {
        String read = "";
        
        try {
            if(tokenizer == null || !tokenizer.hasMoreTokens()) {
                while(!in.ready()) {}
                String inLine = in.readLine();
                tokenizer = new StringTokenizer(inLine);
            } 
            read = tokenizer.nextToken();
        } catch(IOException io) {
            System.out.println("An IO error occurred");
            io.printStackTrace();
            System.exit(0);
        } catch(Exception ex) {
            System.out.println("An unexpected error occurred");
            ex.printStackTrace();
            System.exit(0);
        }
        return read;
    }

    public int readInt() {
        int read = 0;
        
        try {
            if(tokenizer == null || !tokenizer.hasMoreTokens()) {
                while(!in.ready()) {}
                String inLine = in.readLine();
                tokenizer = new StringTokenizer(inLine);
            } 
            read = Integer.parseInt(tokenizer.nextToken()); 
        } catch(NumberFormatException ex) {
            System.out.println("***\nInteger was not entered, try again.\n***");
            return readInt();
        } catch(IOException io) {
            System.out.println("An IO error occurred");
            io.printStackTrace();
            System.exit(0);
        } catch(Exception ex) {
            System.out.println("An unexpected error occurred");
            ex.printStackTrace();
            System.exit(0);
        }
        return read;
    }
    public float readFloat() {
        float read = 0;
        
        try {
            if(tokenizer == null || !tokenizer.hasMoreTokens()) {
                while(!in.ready()) {}
                String inLine = in.readLine();
                tokenizer = new StringTokenizer(inLine);
            } 
            read = Float.parseFloat(tokenizer.nextToken()); 
        } catch(NumberFormatException ex) {
            System.out.println("***\nFloat was not entered, try again.\n***");
            return readFloat();
        } catch(IOException io) {
            System.out.println("An IO error occurred");
            io.printStackTrace();
            System.exit(0);
        } catch(Exception ex) {
            System.out.println("An unexpected error occurred");
            ex.printStackTrace();
            System.exit(0);
        }
        return read;
    }
    public double readDouble() {
        double read = 0;
        
        try {
            if(tokenizer == null || !tokenizer.hasMoreTokens()) {
                while(!in.ready()) {}
                String inLine = in.readLine();
                tokenizer = new StringTokenizer(inLine);
            } 
            read = Double.parseDouble(tokenizer.nextToken()); 
        } catch(NumberFormatException ex) {
            System.out.println("***\nDouble was not entered, try again.\n***");
            return readDouble();
        } catch(IOException io) {
            System.out.println("An IO error occurred");
            io.printStackTrace();
            System.exit(0);
        } catch(Exception ex) {
            System.out.println("An unexpected error occurred");
            ex.printStackTrace();
            System.exit(0);
        }
        return read;
    }
    public double readByte() {
        double read = 0;
        
        try {
            if(tokenizer == null || !tokenizer.hasMoreTokens()) {
                while(!in.ready()) {}
                String inLine = in.readLine();
                tokenizer = new StringTokenizer(inLine);
            } 
            read = Byte.parseByte(tokenizer.nextToken()); 
        } catch(NumberFormatException ex) {
            System.out.println("***\nByte was not entered, try again.\n***");
            return readDouble();
        } catch(IOException io) {
            System.out.println("An IO error occurred");
            io.printStackTrace();
            System.exit(0);
        } catch(Exception ex) {
            System.out.println("An unexpected error occurred");
            ex.printStackTrace();
            System.exit(0);
        }
        return read;
    }
    
    public String nextLine() {
        String read = "";
        
        try {
            if(tokenizer == null || !tokenizer.hasMoreTokens()) {
                while(!in.ready()) {}
                String inLine = in.readLine();
                tokenizer = new StringTokenizer(inLine);
            } 
            read = tokenizer.nextToken();
        } catch(IOException io) {
            System.out.println("An IO error occurred");
            io.printStackTrace();
            System.exit(0);
        } catch(Exception ex) {
            System.out.println("An unexpected error occurred");
            ex.printStackTrace();
            System.exit(0);
        }
        return read;
    }

    public int nextInt() {
        int read = 0;
        
        try {
            if(tokenizer == null || !tokenizer.hasMoreTokens()) {
                while(!in.ready()) {}
                String inLine = in.readLine();
                tokenizer = new StringTokenizer(inLine);
            } 
            read = Integer.parseInt(tokenizer.nextToken()); 
        } catch(NumberFormatException ex) {
            System.out.println("***\nInteger was not entered, try again.\n***");
            return readInt();
        } catch(IOException io) {
            System.out.println("An IO error occurred");
            io.printStackTrace();
            System.exit(0);
        } catch(Exception ex) {
            System.out.println("An unexpected error occurred");
            ex.printStackTrace();
            System.exit(0);
        }
        return read;
    }
    public float nextFloat() {
        float read = 0;
        
        try {
            if(tokenizer == null || !tokenizer.hasMoreTokens()) {
                while(!in.ready()) {}
                String inLine = in.readLine();
                tokenizer = new StringTokenizer(inLine);
            } 
            read = Float.parseFloat(tokenizer.nextToken()); 
        } catch(NumberFormatException ex) {
            System.out.println("***\nFloat was not entered, try again.\n***");
            return readFloat();
        } catch(IOException io) {
            System.out.println("An IO error occurred");
            io.printStackTrace();
            System.exit(0);
        } catch(Exception ex) {
            System.out.println("An unexpected error occurred");
            ex.printStackTrace();
            System.exit(0);
        }
        return read;
    }
    public double nextDouble() {
        double read = 0;
        
        try {
            if(tokenizer == null || !tokenizer.hasMoreTokens()) {
                while(!in.ready()) {}
                String inLine = in.readLine();
                tokenizer = new StringTokenizer(inLine);
            } 
            read = Double.parseDouble(tokenizer.nextToken()); 
        } catch(NumberFormatException ex) {
            System.out.println("***\nDouble was not entered, try again.\n***");
            return readDouble();
        } catch(IOException io) {
            System.out.println("An IO error occurred");
            io.printStackTrace();
            System.exit(0);
        } catch(Exception ex) {
            System.out.println("An unexpected error occurred");
            ex.printStackTrace();
            System.exit(0);
        }
        return read;
    }
}
