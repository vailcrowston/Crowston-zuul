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
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room makeupStudio, boutique, flowerGarden, spa, coffeeShop, fashionRunway;
      
        // create the rooms
        makeupStudio = new Room("in a glamorous makeup studio.");
        boutique = new Room("in a stylish boutique filled with the latest trends.");
        flowerGarden = new Room("in a flower garden, bursting with colorful plants.");
        spa = new Room("in a spa");
        coffeeShop = new Room("in a cozy coffee shop.");
        fashionRunway = new Room("on a fashion runway, lights flashing and music playing.");

        // initialize room exits using the HashMap
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
        
        // Print the starting location info
        printLocationInfo();
    }

    /**
     * Print the current location's description and available exits.
     */
    private void printLocationInfo() 
    {
        // Print the current room's description
        System.out.println("You are " + currentRoom.getDescription());
        
        // Print available exits
        System.out.println(currentRoom.getExitString());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean, girly...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }

        return wantToQuit;
    }

    // User command implementations:

    /**
     * Print out some help information.
     * Here we print a friendly message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You're fabulous! Don't worry, I got you covered.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   go quit help");
    }

    /**
     * Try to go in one direction. If there is an exit, enter the new room,
     * otherwise print an error message.
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
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what, Girly?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
