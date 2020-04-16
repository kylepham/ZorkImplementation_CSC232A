import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Iterator;

class Location
{
    private String name, description;
	private ArrayList<Item> items;
	private HashMap<String, Location> connections;

	/***
	 * Construct Location object with a given name and given description
	 * @param name
	 * @param description
	 */
    public Location(String name, String description)
    {
        this.name = name;
        this.description = description;
        this.items = new ArrayList<Item>();
        this.connections = new HashMap<String, Location>();
    } 

    // Accessor for the name
    public String getName()
    {
        return this.name;
    }

    // Accessor for the description
    public String getDescription()
    {
        return this.description;
    }

    // Mutator for the name
    public void setName(String name)
    {
        this.name = name;
    }

    // Mutator for the description
    public void setDescription(String description)
    {
        this.description = description;
    }

    //Add i to the items ArrayList
    public void addItem(Item item)
    {
        this.items.add(item);
    }

    //Check the items in the ArrayList
    public boolean hasItem(String i)
    {
        i = i.toLowerCase();
        for (Item item: this.items)
            if (item.getName().toLowerCase().equals(i))
                return true;
		return false;
    }

    //Return the item from the list
    public Item getItem(String i)
    {
        i = i.toLowerCase();
        for (Item item: this.items)
            if (item.getName().toLowerCase().equals(i))
                return item;
        return null;
    }

    //Return the item by index
    public Item getItem(int i)
    {
    	if (i >= 0 && i < this.items.size())
    		return this.items.get(i);
    	return null;
    }

    //Count the available items in the list
    public int numItems()
    {
        return this.items.size();
    }

    //Remove items from the list
    public Item removeItem(String i)
    {
    	i = i.toLowerCase();
        for (Item item: this.items)
            if (item.getName().toLowerCase().equals(i))
            {
                Item ret = new Item(item);
                this.items.remove(item);
				return ret;
			}
		return null;
    }
    
    /***
     * Connect this location to another location with a given direction
     * @param direction
     * @param location
     * @return None
     * @
     */
    public void connect(String direction, Location location)
    {
    	direction = direction.toLowerCase();
    	this.connections.put(direction, location);
    }
    
    /***
     * Check if this location is connected with another in a given direction
     * @param direction
     * @return True/False
     */
    public boolean canMove(String direction)
    {
    	direction = direction.toLowerCase();
    	return this.connections.containsKey(direction);
    }
    
    /***
     * Get the location object associated with a given direction
     * @param direction
     * @return Location object/Null
     */
    public Location getLocation(String direction)
    {
    	direction = direction.toLowerCase();
    	if (this.canMove(direction))
    		return this.connections.get(direction);
    	return null;
    }
    
    
}