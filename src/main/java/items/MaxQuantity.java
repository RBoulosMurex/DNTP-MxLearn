package items;

public class MaxQuantity {
    public static int evaluate(Item item) {
        if(item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return 80;
        }
        return 50;
    }
}
