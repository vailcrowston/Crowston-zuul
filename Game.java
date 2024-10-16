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

    /**
     * Create the game and initialize its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();  // Assuming Parser is properly defined elsewhere
    }

    /**
     * Create all the rooms and link their exits together. Also, add items to some rooms.
     */
    private void createRooms()
    {
        Room makeupStudio, boutique, flowerGarden, spa, coffeeShop, fashionRunway;

        // Create the rooms
        makeupStudio = new Room("in a glamorous makeup studio.");
        boutique = new Room("in a stylish boutique filled with the latest trends.");
        flowerGarden = new Room("in a flower garden, bursting with colorful plants.");
        spa = new Room("in a spa");
        coffeeShop = new Room("in a cozy coffee shop.");
        fashionRunway = new Room("on a fashion runway, lights flashing and music playing.");

        // Create items
        Item lipstick = new Item("a shiny lipstick", 0.2);
        Item dress = new Item("a designer dress", 1.5);
        Item coffee = new Item("a cup of espresso", 0.3);

        // Assign items to rooms
        makeupStudio.setItem(lipstick);
        boutique.setItem(dress);
        coffeeShop.setItem(coffee);

        // Initialize room exits
        makeupStudio.setExit("north", spa);
        makeupStudio.setExit("east", boutique);
        
        boutique.setExit("west", makeupStudio);
        
        flowerGarden.setExit("east", spa);
        flowerGarden.setExit("west", coffeeShop);
        
        spa.setExit("south", makeupStudio);
        spa.setExit("north", flowerGarden);
        
        coffeeShop.setExit("east", flowerGarden);
        
        fashionRunway.setExit("south", coffeeShop);

        currentRoom = makeupStudio;  // start game in the makeup studio
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
     * Print the current location's description and available exits.
     */
    private void printLocationInfo() 
    {
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Process a command from the player and act accordingly.
     * @param command The command to process.
     * @return true if the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        String commandWord = command.getCommandWord();

        switch (commandWord) {
            case "help":
                printHelp();
                break;
            case "go":
                goRoom(command);
                break;
            case "look":
                look();
                break;
            case "nap":
                nap();
                break;
            case "quit":
                wantToQuit = quit(command);
                break;
            default:
                System.out.println("I don't know what you mean, girly...");
                break;
        }
        return wantToQuit;
    }

    /**
     * Print out some help information.
     */
    private void printHelp() 
    {
        System.out.println("You're fabulous! Don't worry, I got you covered.");
        System.out.println("Your command words are:");
        parser.getCommandsList();
    }

    /**
     * Handle the "look" command.
     */
    private void look() 
    {
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Handle the "nap" command.
     */
    private void nap() 
    {
        System.out.println("You have napped now and you have endorphins!");
    }

    /**
     * Try to go in one direction. If there is an exit, enter the new room.
     * Otherwise, print an error message.
     */
    private void goRoom(Command command) 
    {
        if (!command.hasSecondWord()) {
            System.out.println("Go where, Girly?");
            return;
        }

        String direction = command.getSecondWord();
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("Oops! No way to go that way!");
        } else {
            currentRoom = nextRoom;
            printLocationInfo();
        }
    }

    /**
     * Handle the "quit" command. Return true if the game should end, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if (command.hasSecondWord()) {
            System.out.println("Quit what, Girly?");
            return false;
        } else {
            return true;  // signal that we want to quit
        }
    }
}

