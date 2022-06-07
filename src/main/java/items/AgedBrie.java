package items;

public class AgedBrie implements UpdatableItem {
    private Item item;
    public AgedBrie(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        item.sellIn -= 1;
        item.quality += 1;
    }
}
