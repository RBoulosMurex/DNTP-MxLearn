package items;

public class Sulfuras implements UpdatableItem {
    private Item item;
    public Sulfuras(Item item) {
        this.item = item;
        this.item.quality = 80;
    }
    public void update() {}
}
