package items;

public class BackstagePasses implements UpdatableItem {
    private Item item;
    public BackstagePasses(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        item.sellIn -= 1;
        int days = item.sellIn;
        if(days >= 10) {
            item.quality += 1;
        } else if(days >= 5) {
            item.quality += 2;
        } else if(days >= 0) {
            item.quality += 3;
        } else {
            item.quality = 0;
        }
    }
}
