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
    private static final String[] validCommands = {
        "go", "quit", "help", "look", "nap"  // Existing commands
    };

    /**
     * Return a string containing all valid commands.
     * @return A string containing all the valid commands.
     */
    public String getCommandList()
    {
        StringBuilder commandsList = new StringBuilder();
        for (String command : validCommands) {
            commandsList.append(command).append(" ");
        }
        return commandsList.toString().trim();  // Return the list of commands as a single string
    }

    /**
     * Check whether a given String is a valid command word.
     * @return true if a given string is a valid command, false otherwise.
     */
    public boolean isCommand(String aString)
    {
        for (String command : validCommands) {
            if (command.equals(aString)) {
                return true;
            }
        }
        return false;
    }
}
