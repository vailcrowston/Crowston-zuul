import java.util.HashMap;

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



import java.util.HashMap;

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;  // stores exits for directions
    private Item item;  // Each room can hold one item
    
    /**
     * Create a room described by "description". Initially, it has no exits and no item.
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        this.exits = new HashMap<>();  // Initialize the exits map
        this.item = null;  // No item in the room initially
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
     * Set an item for this room.
     * @param item The item to be placed in this room.
     */
    public void setItem(Item item)
    {
        this.item = item;
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
     * Return a description of the room's exits, for example, "Exits: north west".
     * @return A description of the available exits.
     */
    public String getExitString()
    {
        StringBuilder exitString = new StringBuilder("Exits: ");
        for (String direction : exits.keySet()) {
            exitString.append(direction).append(" ");
        }
        return exitString.toString().trim();  // Trim to remove trailing space
    }

    /**
     * Return a long description of this room, including exits and the item (if any).
     * @return A long description of the room.
     */
    public String getLongDescription()
    {
        String roomDescription = "You are " + description + ".\n" + getExitString();
        if (item != null) {
            roomDescription += "\nItem: " + item.getLongDescription();
        }
        return roomDescription;
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

