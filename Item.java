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
public class Item
{
    private String description;
    private double weight;

    /**
     * Constructor to create an item with a description and weight.
     * @param description The item's description.
     * @param weight The item's weight.
     */
    public Item(String description, double weight)
    {
        this.description = description;
        this.weight = weight;
    }

    /**
     * Return the item's description.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Return the item's weight.
     */
    public double getWeight()
    {
        return weight;
    }

    /**
     * Return a long description of the item.
     */
    public String getLongDescription()
    {
        return description + " (Weight: " + weight + ")";
    }
}

