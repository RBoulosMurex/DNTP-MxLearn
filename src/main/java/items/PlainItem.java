package items;

public class PlainItem implements UpdatableItem {
    private Item item;
    public PlainItem(Item item) {
        this.item = item;
    }
    @Override
    public void update() {
        item.sellIn -= 1;
        if(item.sellIn < 0) {
            item.quality -= 2;
        } else {
            item.quality -= 1;
        }
    }
}
