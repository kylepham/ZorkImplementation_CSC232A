import java.util.Scanner;

class Main {
	private static Location currentLocation;
	private static ContainerItem myInventory;
	
    public static void main(String[] args) {
    	createWorld();
        Scanner sc = new Scanner(System.in);
        
        // infinite loop
        boolean isRunning = true;
        while (isRunning)
        {
            System.out.print("Enter command: ");
            String command = sc.next();
            String[] subCommand;
            String item;
            String name, container;
            
            switch (command)
            {
                case "quit":
                    isRunning = false;
                    break;

                case "look":
                    System.out.println(currentLocation.getName() + " - " + currentLocation.getDescription());
                    for (int i = 0; i < currentLocation.numItems(); i++)
                        System.out.println("+ " + currentLocation.getItem(i).getName());
                    break;
                
                case "examine":
                    do
                    {
                        item = sc.nextLine();
                        item = item.trim();
                        if (item.isEmpty())
                            System.out.print("What do you want to examine? ");
                    } while (item.isEmpty());

                    Item it = currentLocation.getItem(item);
                    if (it != null)
                        System.out.println(it.getName() + " - " + it.getDescription());
                    else
                        System.out.println("Cannot find that item");
                    break;
                
                case "go":
                	String direction;
                    do
                    {
                    	direction = sc.nextLine();
                    	direction = direction.trim();
                        if (direction.isEmpty())
                            System.out.print("Which direction do you want to go? ");
                    } while (direction.isEmpty());
                    direction = direction.toLowerCase();
                    if (direction.equals("north") || direction.equals("south") || direction.equals("west") || direction.equals("east"))
                    {
                    	if (currentLocation.canMove(direction))
                    		currentLocation = currentLocation.getLocation(direction);
                    	else
                    		System.out.println("There is no place in this direction");
                    }
                    else
                    {
                    	System.out.println("I cannot recognize this direction");
                    }
                    break;
                    
                case "inventory":
                	System.out.println(myInventory);
                	break;
                	
                case "take":
                    do
                    {
                        item = sc.nextLine();
                        item = item.trim();
                        if (item.isEmpty())
                            System.out.print("What do you want to take? ");
                    } while (item.isEmpty());
                    subCommand = item.split(" from ");
                    
                    // if the command is "take [x]"
                    if (subCommand.length == 1)
                    {
	                    if (currentLocation.hasItem(item))
	                    	myInventory.addItem(currentLocation.removeItem(item));	
	                    else
	                    	System.out.println("I can't find that item here");
                    }
                    // if the command is "take [x] from [y]"
                    else if (subCommand.length == 2)
                    {
                    	name = subCommand[0].trim();
                    	container = subCommand[1].trim();
                    	if (currentLocation.hasItem(container))
                    	{
                    		ContainerItem containerItem = (ContainerItem) currentLocation.getItem(container);
                    		if (containerItem.hasItem(name))
                    		{
                    			myInventory.addItem(containerItem.removeItem(name));
                    		}
                    		else
                    			System.out.println("I cannot find that item here");
                    	}
                    	else
                    		System.out.println("I cannot find that container here");
                    }
                    else
                    	System.out.println("It is not a valid command");
                	break;
                	
                case "drop":
                	do
                    {
                        item = sc.nextLine();
                        item = item.trim();
                        if (item.isEmpty())
                            System.out.print("What do you want to drop? ");
                    } while (item.isEmpty());
                	if (myInventory.hasItem(item))
                		currentLocation.addItem(myInventory.removeItem(item));
                	else
                		System.out.println("I can't find that item in your inventory");
                	break;
                	
                case "help":
                	System.out.println("Type 'look' to see what is at your location");
                	System.out.println("Type 'inventory' to see what is in your inventory");
                	System.out.println("Type 'quit' to quit the game");
                	System.out.println("Type 'examine x' - x is the item's name - to get its description");
                	System.out.println("Type 'go x' - x is a direction - to go the direction of your choice, either North, South, West, or East");
                	System.out.println("Type 'take x' - x is the item's name - to put that item from the location to your inventory");
                	System.out.println("Type 'drop x' - x is the item's name - to drop that item from your inventory to the location");
                	System.out.println("-------------- HAVE FUN --------------");
                	break;
                	
                case "put":
                	do
                    {
                        item = sc.nextLine();
                        item = item.trim();
                        if (item.isEmpty())
                            System.out.print("What do you want to put? ");
                    } while (item.isEmpty());
                	subCommand = item.split(" in ");
                	if (subCommand.length == 2)
                	{
                		name = subCommand[0].trim();
                    	container = subCommand[1].trim();
                    	if (currentLocation.hasItem(container))
                    	{
                    		if (myInventory.hasItem(name))
                    			((ContainerItem) currentLocation.getItem(container)).addItem(myInventory.removeItem(name));
                    		else
                    			System.out.println("I can't find that item in your inventory");
                    	}
                    	else
                    		System.out.println("I can't find that container here");
                	}
                	else
                		System.out.println("It's not a valid command");
                	
                	break;
                    
                default:
                    System.out.println("I don’t know how to do that");
                    break;
            }
        }
        sc.close();
    }
    
    private static void createWorld()
    {
    	Location kitchen = new Location("Kitchen", "Cooking place");
    	kitchen.addItem(new Item("Kettle", "Appliance", "Perfect for brewing hot tea and coffee"));
    	kitchen.addItem(new Item("Turkey", "Food", "Good but not the best meat type"));
    	kitchen.addItem(new Item("Plate", "Dinnerware", "Shiny silver ellipse object"));
    	kitchen.addItem(new Item("Toaster", "Appliance", "Stainless Classic Toaster"));
    	kitchen.addItem(new ContainerItem("Toolbox", "Container", "A wooden box"));
    	((ContainerItem) kitchen.getItem("Toolbox")).addItem(new Item("Knife", "Cutlery", "Japanese Knife"));
    	((ContainerItem) kitchen.getItem("Toolbox")).addItem(new Item("Cutting Board", "Tool", "Plastic Board"));
    
		Location bedroom = new Location("Bedroom", "Sleeping place");
		bedroom.addItem(new Item("Bed", "Furniture", "Softest Bed on Earth"));
		bedroom.addItem(new Item("Wardrobe", "Furniture", "Old Wardrobe from the 90s"));
		bedroom.addItem(new Item("Lamp", "Furniture", "Rich textures, highlighted in silver leaf"));
		bedroom.addItem(new Item("Crib", "Furniture", "Easy to re-style and re-arrange"));
		bedroom.addItem(new ContainerItem("Dresser", "Container", "Three-drawer chest"));
    	((ContainerItem) bedroom.getItem("Dresser")).addItem(new Item("Tee", "Clothes", "H&M Slim Fit"));
    	((ContainerItem) bedroom.getItem("Dresser")).addItem(new Item("Hoodie", "Clothes", "Soft, brushed inside"));
    	
		Location hallway = new Location("Hallway", "Path to go outside");
		hallway.addItem(new Item("Ball", "Toy", "Ultra-durable and Chewy"));
		hallway.addItem(new Item("Golf Stick", "Tool", "Fancy Golf Stick"));
		hallway.addItem(new Item("Rug", "Decor", "Soft and Luxurious"));
		hallway.addItem(new Item("Sword", "Decor", "An Old Sword from the ancient Greece"));
		hallway.addItem(new ContainerItem("Chest", "Container", "Made of 100% natural bamboo"));
    	((ContainerItem) hallway.getItem("Chest")).addItem(new Item("Adidas Shoes", "Shoes", "8.5 White Basketball Shoes"));
    	((ContainerItem) hallway.getItem("Chest")).addItem(new Item("Fur Slippers", "Slippers", "Grey, Ombre"));
    	
		Location bathroom = new Location("Bathroom", "Shower");
		bathroom.addItem(new Item("Razor", "Blade", "Unisex, Double sided, Handmade Metal"));
		bathroom.addItem(new Item("Hairdryer", "Tool", "Salon-quality hairdryer"));
		bathroom.addItem(new Item("Towels", "Towel", "Extremely Soft on Face"));
		bathroom.addItem(new Item("Waste Basket", "Basket", "Open, Steel in Black, with small capacity"));
		bathroom.addItem(new ContainerItem("Caddy", "Container", "A wooden box"));
    	((ContainerItem) bathroom.getItem("Caddy")).addItem(new Item("Shampoo", "Tool", "Expensive Shampoo"));
    	((ContainerItem) bathroom.getItem("Caddy")).addItem(new Item("Conditioner", "Tool", "Empty bottle of Hair Conditioner"));
    	
		// connect all 4 to some of the others
		kitchen.connect("north", hallway);
		kitchen.connect("east", bathroom);
		
		hallway.connect("south", kitchen);
		
		bathroom.connect("west", kitchen);
		bathroom.connect("south", bedroom);
		
		bedroom.connect("north", bathroom);
		
		//assign currentLocation to kitchen
		currentLocation = kitchen;
		
		//construct myInventory
		myInventory = new ContainerItem("Backpack", "Container", "My own storage");
		
		
    }
}
