class Main {
    public static void main(String[] args) {
        Item it = new Item("Sandwich", "Food", "A peanut butter and jelly sandwich");
        it.setType("Shit");
        System.out.println(it.toString());
        Location m = new Location("House", "Pikachu");
        System.out.println(m.getNameLocal());
        m.addItem("Pikachu");
        m.addItem("Ash");
        m.addItem("Bê đê");
        System.out.println(m.removeItem("Pikachu"));
    }
}
