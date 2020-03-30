import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Location loc = new Location("Kitchen", "Cooking place");

		Item k = new Item("Knife", "Tool", "Deadliest cooking material");
		Item t = new Item("Turkey", "Food", "Good but not the best meat type");
		Item p = new Item("Plate", "Tool", "Shiny silver ellipse object");

		loc.addItem(k);
		loc.addItem(t);
		loc.addItem(p);

        Scanner sc = new Scanner(System.in);
        
        // infinite loop
        while (true)
        {
            System.out.print("Enter command: ");
            String command = sc.next();
            
            if (command.equals("quit"))
                break;
            
            else if (command.equals("look"))
            {
                System.out.println(loc.getName() + " - " + loc.getDescription());
                loc.printItems();
            }

            else if (command.equals("examine"))
            {
                String item;
                do
                {
                    item = sc.nextLine();
                    item = item.trim();
                    if (item.isEmpty())
                        System.out.print("What do you want to examine? ");
                } while (item.isEmpty());
                Item it = loc.getItem(item);
                if (it != null)
                    System.out.println(it.getName() + " - " + it.getDescription());
                else
                    System.out.println("Cannot find that item");
            }

            else
                System.out.println("I don’t know how to do that");
        }
    }
}
