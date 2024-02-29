package Random_Stuff.Installer;


/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String[] args) {
        GUIManager manager = new GUIManager();
        
        manager.show();
        
        while(!manager.isReady()) {}
        
        
    }
}
