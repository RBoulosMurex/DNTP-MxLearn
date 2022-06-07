package items;

public class Conjured implements UpdatableItem {
    private Item item;
    public Conjured(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        item.sellIn -= 1;
        if(item.sellIn < 0) {
            item.quality -= 4;
        } else {
            item.quality -= 2;
        }
    }
}
