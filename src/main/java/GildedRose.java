import items.Item;
import items.ItemFactory;
import items.UpdatableItem;
import items.MaxQuantity;

public class GildedRose {
    private static final int MINIMUM_QUALITY = 0;
    private Item[] items;
    public GildedRose(Item[] items) {
        this.items = items;
    }
    public void updateQuality() {
        for(Item item: items) {
            UpdatableItem result = ItemFactory.generate(item);
            //int MAXIMUM_QUALITY = MaxQuantity.evaluate(item);
            int MAXIMUM_QUALITY = GildedRose.getMax(item);
            result.update();
            if(item.quality < MINIMUM_QUALITY) {item.quality = MINIMUM_QUALITY;}
            if(item.quality > MAXIMUM_QUALITY) {item.quality = MAXIMUM_QUALITY;}
        }
    }

    public Item[] getItems() {
        return this.items;
    }
    private static int getMax(Item item) {
        if(item.name.startsWith("Sulfuras")) {
            return 80;
        }
        return 50;
    }
}
