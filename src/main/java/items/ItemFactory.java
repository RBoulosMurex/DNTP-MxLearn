package items;

public class ItemFactory {
    public static UpdatableItem generate(Item item) {
        switch (item.name) {
            case "Sulfuras, Hand of Ragnaros":
                return new Sulfuras(item);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePasses(item);
            case "Conjured Mana Cake":
                return new Conjured(item);
            case "Aged Brie":
                return new AgedBrie(item);
            default:
                return new PlainItem(item);
        }
    }
}
