package Random_Stuff;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.Integer;

public class KnockKnockServer {
    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);
        try (
            ServerSocket serverSocket = new ServerSocket(port, 2);
            Socket clientSocket = serverSocket.accept();
            
            PrintWriter out = new PrintWriter(
                clientSocket.getOutputStream(), true);
                
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        ) {
            String inLine, outLine;
            
            // Initiates conversation with the client.
            KnockKnockProtocol kkp = new KnockKnockProtocol();
            outLine = kkp.processInput(null);
            out.println(outLine);
            
            while((inLine = in.readLine()) != null) {
                outLine = kkp.processInput(inLine);
                out.println(outLine);
                if(outLine.equals("Bye.")) break;
            }
        }
        catch(IOException ex) {
            
        }
    }
}
