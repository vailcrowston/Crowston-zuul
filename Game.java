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

public class Game 
{
    private Parser parser;
    private Room currentRoom;

    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Main play routine. Loops until the game ends.
     */
    public void play() 
    {            
        printWelcome();

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing. Bye, Girly!");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to Girly World!");
        System.out.println("In Girly World, you can explore fun and fabulous places.");
        System.out.println("Type 'help' if you need assistance.");
        System.out.println();
        printLocationInfo();
    }

    /**
     * Print out some help information.
     */
    private void printHelp() 
    {
        System.out.println("You're fabulous! Don't worry, I got you covered.");
        System.out.println("Your command words are:");
        parser.showCommands();  // Delegates to the parser to show valid commands
    }

    /**
     * Print the current location's description and available exits.
     */
    private void printLocationInfo() 
    {
        System.out.println(currentRoom.getLongDescription());
    }

    // Other methods...
}

