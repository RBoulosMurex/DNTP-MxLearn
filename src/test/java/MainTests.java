import items.Item;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTests {
    @Test
    public void foo() {
        GildedRose app = newGildedRose("foo", 0, 0);
        app.updateQuality();
        Assert.assertEquals("foo", app.getItems()[0].name);
    }

    @Test
    public void plainItemDecreasesSellByDayNumberEachTime() {
        GildedRose app = newGildedRose("standard item", 0, 0);

        app.updateQuality();

        assertEquals("Failure - SellIn Value Didn't Decrease", -1, itemSellByDayNumber(app));
    }

    @Test
    public void plainItemDecreasesQualityBy1WhenSellIsPositive() {
        GildedRose app = newGildedRose("standard item", 2, 19);

        app.updateQuality();

        assertEquals("Failure - Quality didn't decrement", 18, itemQualityValue(app));
    }

    @Test
    public void plainItemDecreasesQualityBy2WhenSellIsNegative() {
        GildedRose app = newGildedRose("standard item", -1, 19);

        app.updateQuality();

        assertEquals("Failure - Plain item quality didn't decrease by 2 although sell is negative", 17, itemQualityValue(app));
    }


    @Test
    public void plainItemQualityNonVaryingBeneathZero() {
        GildedRose app = newGildedRose("standard item", 3, 0);

        app.updateQuality();

        assertEquals("Failure - Quality is beneath zero", 0, itemQualityValue(app));
    }

    @Test
    public void plainItemQualityDoesntTrespass50() {
        GildedRose app = newGildedRose("item", 3, 52);

        app.updateQuality();

        assertEquals("Failure - Quality trespassed 50", 50, itemQualityValue(app));
    }

    @Test
    public void agedBrieDecreasesSellByDayNumberEachTime() {
        GildedRose app = newGildedRose("Aged Brie", 0, 0);

        app.updateQuality();

        assertEquals("Failure - Sell value didn't decrease", -1, itemSellByDayNumber(app));
    }

    @Test
    public void agedBrieQualityIncrements() {
        GildedRose app = newGildedRose("Aged Brie", 0, 0);

        app.updateQuality();

        assertEquals("Failure - Aged brie quality didn't increase", 1, itemQualityValue(app));
    }

    @Test
    public void agedBrieQualityDoesntTrespass50() {
        GildedRose app = newGildedRose("Aged Brie", 0, 50);

        app.updateQuality();

        assertEquals(50, itemQualityValue(app));
    }

    @Test
    public void agedBrieQualityDoesntGoBeyond0() {
        GildedRose app = newGildedRose("Aged Brie", 0, 50);

        app.updateQuality();

        assertEquals(50, itemQualityValue(app));
    }

    @Test
    public void backstagePassesDoesntTrespass50() {
        GildedRose app = newGildedRose("Backstage passes to a TAFKAL80ETC concert", 5, 50);

        app.updateQuality();

        assertEquals(50, itemQualityValue(app));
    }

    @Test
    public void backstagePassesIncrements1QualityForMoreThan10Days() {
        GildedRose app = newGildedRose("Backstage passes to a TAFKAL80ETC concert", 11, 49);

        app.updateQuality();

        assertEquals(50, itemQualityValue(app));
    }

    @Test
    public void backstagePassesIncrements2QualityForLessThan10Days() {
        GildedRose app = newGildedRose("Backstage passes to a TAFKAL80ETC concert", 8, 45);

        app.updateQuality();

        assertEquals(47, itemQualityValue(app));
    }

    @Test
    public void backstagePassesIncrements3QualityForLessThan5Days() {
        GildedRose app = newGildedRose("Backstage passes to a TAFKAL80ETC concert", 4, 43);

        app.updateQuality();

        assertEquals(46, itemQualityValue(app));
    }

    @Test
    public void backstagePassesQualityNullWhenConcertHasPassed() {
        GildedRose app = newGildedRose("Backstage passes to a TAFKAL80ETC concert", 0, 20);

        app.updateQuality();

        assertEquals(0, itemQualityValue(app));
    }

    @Test
    public void sulfurasUnphasedSellNorQualityValues() {
        GildedRose app = newGildedRose("Sulfuras, Hand of Ragnaros", 4, 80);

        app.updateQuality();

        assertEquals(80, itemQualityValue(app));
        assertEquals(4, itemSellByDayNumber(app));
    }

    @Test
    public void sulfurasQualityIsAlways80() {
        GildedRose app = newGildedRose("Sulfuras, Hand of Ragnaros", 4, 0);

        app.updateQuality();

        assertEquals("Failure - Quality isn't 80", 80, itemQualityValue(app));
    }

    @Test
    public void conjuredItemDegradesBy2WhenSellIsPositive() {
        GildedRose app = newGildedRose("Conjured Mana Cake", 5, 20);

        app.updateQuality();

        assertEquals(18, itemQualityValue(app));
    }

    @Test
    public void conjuredItemDegradesBy4WhenSellIsNegative() {
        GildedRose app = newGildedRose("Conjured Mana Cake", -1, 20);

        app.updateQuality();

        assertEquals(16, itemQualityValue(app));
    }
    @Test
    public void conjuredItemCannotBeBeneathZero() {
        GildedRose app = newGildedRose("Conjured Mana Cake", 5, 0);

        app.updateQuality();

        assertEquals(0, itemQualityValue(app));
    }

    @Test
    public void conjuredItemDecreasesSellNumberEachDay() {
        GildedRose app = newGildedRose("Conjured Mana Cake", 5, 20);

        app.updateQuality();

        assertEquals(4, itemSellByDayNumber(app));
    }


    private GildedRose newGildedRose(String itemName, int itemSellIn, int itemQuality) {
        Item[] items = new Item[] { new Item(itemName, itemSellIn, itemQuality)};
        return new GildedRose(items);
    }

    private int itemSellByDayNumber(GildedRose app) {
        return app.getItems()[0].sellIn;
    }

    private int itemQualityValue(GildedRose app) {
        return app.getItems()[0].quality;
    }
}


