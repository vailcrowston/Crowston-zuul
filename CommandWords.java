/**
 *  An updated variation of World of Zuul called, Girly World. 
 *  Here in Girly World, we have six rooms: 
 *  a makeup studio, a boutique, a flower garden, a spa, a coffee shop, and a fashion runway.
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 * @author  Vail Crowston
 */

public class CommandWords
{
    // A constant array that holds all valid command words
    private static final String validCommands[] = {
        "go", "quit", "help", "look", "nap"  // Added "look" and "nap" to the valid commands
    };

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command, false otherwise.
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        return false;
    }

    /**
     * Print all valid commands to the console.
     */
    public void showAll()
    {
        for(String command : validCommands) {
            System.out.print(command + " ");
        }
        System.out.println();
    }
}
