import java.util.ArrayList;
class Location
{
    /* Bu's work */
  private String nameLocal, description;
  private ArrayList<String> items;

  public Location(String pnameLocal, String pdescription)
  {
    nameLocal = pnameLocal;
    description = pdescription;
    items = new ArrayList<String>();
  } 

  // Accessor for the name
  public String getNameLocal()
  {
    return nameLocal;
  }

  // Accessor for the description
  public String getDescription()
  {
    return description;
  }

  // Mutator for the name
  public void setNameLocal(String pnameLocal)
  {
    nameLocal = pnameLocal;
  }

  // Mutator for the description
  public void setDescription(String pdescription)
  {
    description = pdescription;
  }

  //Add i to the items ArrayList
  public void addItem(String i)
  {
    items.add(i);
  }

  //Check the items in the ArrayList - T eo bik ong co cho xai built-in function ko nha
  public boolean hasItem(String i)
  {
    return items.contains(i);
  }

  //Return the item from the list
  public String getItem(String i)
  {
    int n = 0;
    while(items.get(n).isEmpty() == false)
    {
      if(i == items.get(n))
      {
        return items.get(n);
      }
      
      else
      {
        n = n+1;
      }
    }
    return null;
  }

  //Count the available items in the list
  public int numItems()
  {
    int count = 1;
    int n = 0;
    while(items.get(n).isEmpty() == false)
    {
      count = count + 1;
      n = n + 1;
    }
    return count;
  }

  //Remove items from the list - cái return items object t ko chắc nha
  public ArrayList<String> removeItem(String i)
  {
    items.remove(i);
    return items;
  }
}