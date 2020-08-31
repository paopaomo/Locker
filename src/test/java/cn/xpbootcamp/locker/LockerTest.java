package cn.xpbootcamp.locker;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LockerTest {
    @Test
    public void should_print_a_receipt_when_storage_bag_given_locker_with_an_opening() {
        Locker locker = new Locker(10);
        Bag bag = new Bag();

        Receipt receipt = locker.storageBag(bag);

        Assert.assertEquals(Receipt.class, receipt.getClass());
    }

    @Test
    public void should_indicate_the_locker_is_full_when_storage_bag_given_locker_without_an_opening() {
        Locker locker = new Locker(1);
        Bag bag1 = new Bag();
        locker.storageBag(bag1);

        assertThrows(LockerIsFullException.class, () -> {
            Bag bag2 = new Bag();
            locker.storageBag(bag2);
        });
    }

    @Test
    public void should_get_the_right_bag_when_take_the_bag_given_a_valid_receipt() {
        Locker locker = new Locker(10);
        Bag bag = new Bag();
        Receipt receipt = locker.storageBag(bag);

        Bag retrieveBag = locker.takeBag(receipt);

        Assert.assertEquals(bag,retrieveBag);
    }

    @Test
    public void should_indicate_the_receipt_is_incorrect_when_take_the_bag_given_a_invalid_receipt() {
        Locker locker = new Locker(10);
        Bag bag = new Bag();
        locker.storageBag(bag);

        assertThrows(ReceiptIsInvalidException.class, () -> {
            Receipt invalidReceipt = new Receipt();
            locker.takeBag(invalidReceipt);
        });
    }

    @Test
    public void should_indicate_the_bag_has_been_picked_up_when_take_the_bag_given_a_duplicate_receipt() {
        Locker locker = new Locker(10);
        Bag bag = new Bag();
        Receipt receipt = locker.storageBag(bag);
        locker.takeBag(receipt);

        assertThrows(BagHasBeenPickedUpException.class, () -> {
            locker.takeBag(receipt);
        });
    }
}
