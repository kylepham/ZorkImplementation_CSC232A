class Main {
    public static void main(String[] args) {
        Item it = new Item("Sandwich", "Food", "A peanut butter and jelly sandwich");
        it.setType("Shit");
        System.out.println(it.toString());
        Location m = new Location("House", "Pikachu");
        System.out.println(m.getNameLocal());
        Item it1 = new Item("Knife", "Tool", "ABCD");
        m.addItem(it);
        m.addItem(it1);
        System.out.println(m.numItems());
        System.out.println(m.getName("Tool"));
    }
}
