package cn.xpbootcamp.locker;

import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class SmartLockerRobotTest {
    @Test
    public void should_save_to_locker1_and_print_a_receipt_when_save_bag_given_locker1_has_10_capacity_and_locker2_has_3_capacity() {
        Locker locker1 = new Locker(10);
        Locker locker2 = new Locker(3);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Lists.newArrayList(locker1, locker2));

        Bag bag = new Bag();
        Receipt receipt = smartLockerRobot.saveBag(bag);

        Assert.assertNotNull(receipt);
        Assert.assertEquals(bag, locker1.takeBag(receipt));
    }

    @Test
    public void should_save_to_locker2_and_print_a_receipt_when_save_bag_given_locker1_has_3_capacity_and_locker2_has_10_capacity() {
        Locker locker1 = new Locker(3);
        Locker locker2 = new Locker(10);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Lists.newArrayList(locker1, locker2));

        Bag bag = new Bag();
        Receipt receipt = smartLockerRobot.saveBag(bag);

        Assert.assertNotNull(receipt);
        Assert.assertEquals(bag, locker2.takeBag(receipt));
    }

    @Test
    public void should_save_to_locker1_and_print_a_receipt_when_save_bag_given_locker1_and_locker2_both_have_3_capacity() {
        Locker locker1 = new Locker(3);
        Locker locker2 = new Locker(3);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Lists.newArrayList(locker1, locker2));

        Bag bag = new Bag();
        Receipt receipt = smartLockerRobot.saveBag(bag);

        Assert.assertNotNull(receipt);
        Assert.assertEquals(bag, locker1.takeBag(receipt));
    }

    @Test
    public void should_throw_LockerIsFullException_when_save_bag_given_locker1_and_locker2_are_both_full() {
        Locker locker1 = new Locker(1);
        Locker locker2 = new Locker(1);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Lists.newArrayList(locker1, locker2));
        locker1.saveBag(new Bag());
        locker2.saveBag(new Bag());

        Assertions.assertThrows(LockerIsFullException.class, () -> {
            smartLockerRobot.saveBag(new Bag());
        });
    }

    @Test
    public void should_take_the_right_bag_when_take_the_bag_given_a_valid_receipt() {
        Locker locker1 = new Locker(10);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Lists.newArrayList(locker1));
        Bag bag = new Bag();
        Receipt receipt = smartLockerRobot.saveBag(bag);

        Bag retrieveBag = smartLockerRobot.takeBag(receipt);

        Assert.assertEquals(bag, retrieveBag);
    }

    @Test
    public void should_throw_ReceiptIsInvalidException_when_take_the_bag_given_a_invalid_receipt() {
        Locker locker1 = new Locker(1);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Lists.newArrayList(locker1));

        Assertions.assertThrows(ReceiptIsInvalidException.class, () -> {
            smartLockerRobot.takeBag(new Receipt());
        });
    }
}
