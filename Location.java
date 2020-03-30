import java.util.ArrayList;
class Location
{
    private String nameLocal, description;
	private ArrayList<Item> items;

    public Location(String nameLocal, String description)
    {
        this.nameLocal = nameLocal;
        this.description = description;
        items = new ArrayList<Item>();
    } 

    // Accessor for the name
    public String getNameLocal()
    {
        return this.nameLocal;
    }

    // Accessor for the description
    public String getDescription()
    {
        return this.description;
    }

    // Mutator for the name
    public void setNameLocal(String nameLocal)
    {
        this.nameLocal = nameLocal;
    }

    // Mutator for the description
    public void setDescription(String description)
    {
        this.description = description;
    }

    //Add i to the items ArrayList
    public void addItem(Item i)
    {
        this.items.add(i);
    }

    //Check the items in the ArrayList
    public boolean hasItem(String i)
    {
        for (Item item: this.items)
            if (item.getName().equals(i))
                return true;
		return false;
    }

    //Return the item from the list
    public Item getItem(String i)
    {
        for (Item item: this.items)
            if (item.getName().equals(i))
                return item;
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
        for (Item item: this.items)
            if (item.getName().equals(i))
            {
                Item ret = new Item(item); // copy constructor
                this.items.remove(item);
				return ret;
			}
		return null;
    }
}