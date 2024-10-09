import java.util.HashMap;

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;  // stores exits for directions
    
    /**
     * Create a room described by "description". Initially, it has
     * no exits.
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();  // Initialize the exits map
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit (e.g., "north", "south", "up", "down").
     * @param neighbor The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);  // Add the exit to the HashMap
    }

    /**
     * Return the room that is reached if we go from this room in the given direction.
     * If there is no room in that direction, return null.
     * @param direction The direction in which to go.
     * @return The room in the given direction, or null if there is no exit.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);  // Get the exit from the HashMap
    }

    /**
     * Return a description of the room's exits, for example,
     * "Exits: north west".
     * @return A description of the available exits.
     */
    public String getExitString()
    {
        // StringBuilder is more efficient for concatenating strings in a loop
        StringBuilder exitString = new StringBuilder("Exits: ");
        for (String direction : exits.keySet()) {
            exitString.append(direction).append(" ");
        }
        return exitString.toString().trim();  // Trim to remove trailing space
    }

    /**
     * Return the description of the room.
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }
}
