package cn.xpbootcamp.locker;

import org.junit.Assert;
import org.junit.Test;

public class LockerTest {
    @Test
    public void should_print_a_receipt_when_storage_bag_given_locker_with_an_opening() {
        Locker locker = new Locker(10);
        Bag bag = new Bag();

        Receipt receipt = locker.storageBag(bag);

        Assert.assertEquals(Receipt.class, receipt.getClass());
    }
}
