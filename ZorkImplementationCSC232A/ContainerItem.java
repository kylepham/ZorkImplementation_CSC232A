import java.util.ArrayList;

public class ContainerItem extends Item {
	private ArrayList<Item> items;
	
	public ContainerItem(String name, String type, String description)
	{
		super(name, type, description);
		this.items = new ArrayList<Item>();
	}
	
	/***
	 * Add new item to the Container
	 * @param item
	 * @return None
	 */
	public void addItem(Item item)
	{
		this.items.add(item);
	}
	
	/***
	 * Check if an item's name exists in the Container
	 * @param name
	 * @return True/False
	 */
	public boolean hasItem(String name)
	{
		name = name.toLowerCase();
		for (Item item: this.items)
			if (item.getName().toLowerCase().equals(name))
				return true;
		return false;
	}
	
	/***
	 * Remove an item based on its name and return that item
	 * @param name
	 * @return Item
	 */
	public Item removeItem(String name)
	{
		name = name.toLowerCase();
		for (Item item: this.items)
			if (item.getName().toLowerCase().equals(name))
			{
				Item ret = new Item(item);
				this.items.remove(item);
				return ret;
			}
		return null;
	}
	
	@Override
	public String toString()
	{
		String contents = "";
		for (Item item: this.items)
			contents = contents + "\n+ " + item.getName();
		if (contents.length() == 0)
			return "The inventory is emtpy";
		return super.getName() + " [" + super.getType() + "]: " + super.getDescription() + " that contains:" + contents; 
	}
	
}
