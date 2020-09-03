package cn.xpbootcamp.locker;

import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;

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
}
