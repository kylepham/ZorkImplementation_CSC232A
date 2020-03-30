class Item
{
    private String name, type, description;

    public Item(String name, String type, String description)
    {
        this.name = name;
        this.type = type;
        this.description = description;
    }

    public Item(Item item)
    {
        this.name = item.name;
        this.type = item.type;
        this.description = item.description;
    }

    public String getName()
    {
        return this.name;
    }

    public String getType()
    {
        return this.type;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String toString()
    {
        return this.name + " [" + this.type + "]: " + this.description;
    }
}