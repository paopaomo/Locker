package cn.xpbootcamp.locker;

import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LockerRobotManagerTest {
    @Test
    public void should_save_by_robot1_and_print_a_receipt_when_save_bag_given_manage_2_robots_with_available_capacity_and_not_manage_locker() {
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Lists.newArrayList(new Locker(10)));
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Lists.newArrayList(new Locker(10)));
        LockerRobotManager lockerRobotManager = new LockerRobotManager();
        lockerRobotManager.manageRobot(Lists.newArrayList(primaryLockerRobot, smartLockerRobot));

        Bag bag = new Bag();
        Receipt receipt = lockerRobotManager.saveBag(bag);

        Assert.assertNotNull(receipt);
        Assert.assertEquals(bag, primaryLockerRobot.takeBag(receipt));
    }

    @Test
    public void should_save_by_robot2_and_print_a_receipt_when_save_bag_given_robot1_is_full_robot2_has_available_capacity_and_not_manage_locker() {
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Lists.newArrayList(new Locker(1)));
        primaryLockerRobot.saveBag(new Bag());
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Lists.newArrayList(new Locker(10)));
        LockerRobotManager lockerRobotManager = new LockerRobotManager();
        lockerRobotManager.manageRobot(Lists.newArrayList(primaryLockerRobot, smartLockerRobot));

        Bag bag = new Bag();
        Receipt receipt = lockerRobotManager.saveBag(bag);

        Assert.assertNotNull(receipt);
        Assert.assertEquals(bag, smartLockerRobot.takeBag(receipt));
    }

    @Test
    public void should_throw_LockerIsFullException_when_save_bag_given_2_robots_are_both_full_and_not_manage_locker() {
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Lists.newArrayList(new Locker(1)));
        primaryLockerRobot.saveBag(new Bag());
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Lists.newArrayList(new Locker(1)));
        smartLockerRobot.saveBag(new Bag());
        LockerRobotManager lockerRobotManager = new LockerRobotManager();
        lockerRobotManager.manageRobot(Lists.newArrayList(primaryLockerRobot, smartLockerRobot));

        assertThrows(LockerIsFullException.class, () -> {
            lockerRobotManager.saveBag(new Bag());
        });
    }

    @Test
    public void should_save_to_locker1_and_print_a_receipt_when_save_bag_given_manage_2_lockers_with_available_capacity_and_not_manage_robot() {
        Locker locker1 = new Locker(10);
        Locker locker2 = new Locker(10);
        LockerRobotManager lockerRobotManager = new LockerRobotManager();
        lockerRobotManager.manageLocker(Lists.newArrayList(locker1, locker2));

        Bag bag = new Bag();
        Receipt receipt = lockerRobotManager.saveBag(bag);

        Assert.assertNotNull(receipt);
        Assert.assertEquals(bag, locker1.takeBag(receipt));
    }

    @Test
    public void should_save_to_locker2_and_print_a_receipt_when_save_bag_given_locker1_is_full_locker2_has_available_capacity_and_not_manage_robot() {
        Locker locker1 = new Locker(1);
        locker1.saveBag(new Bag());
        Locker locker2 = new Locker(10);
        LockerRobotManager lockerRobotManager = new LockerRobotManager();
        lockerRobotManager.manageLocker(Lists.newArrayList(locker1, locker2));

        Bag bag = new Bag();
        Receipt receipt = lockerRobotManager.saveBag(bag);

        Assert.assertNotNull(receipt);
        Assert.assertEquals(bag, locker2.takeBag(receipt));
    }

    @Test
    public void should_throw_LockerIsFullException_when_save_bag_given_2_lockers_are_both_full_and_not_manage_robot() {
        Locker locker1 = new Locker(1);
        locker1.saveBag(new Bag());
        Locker locker2 = new Locker(1);
        locker2.saveBag(new Bag());
        LockerRobotManager lockerRobotManager = new LockerRobotManager();
        lockerRobotManager.manageLocker(Lists.newArrayList(locker1, locker2));

        assertThrows(LockerIsFullException.class, () -> {
            lockerRobotManager.saveBag(new Bag());
        });
    }

    @Test
    public void should_save_by_robot_and_print_a_receipt_when_save_bag_given_manage_1_robot_and_1_locker_both_have_available_capacity() {
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Lists.newArrayList(new Locker(10)));
        Locker locker = new Locker(10);
        LockerRobotManager lockerRobotManager = new LockerRobotManager();
        lockerRobotManager.manageRobot(Lists.newArrayList(primaryLockerRobot));
        lockerRobotManager.manageLocker(Lists.newArrayList(locker));

        Bag bag = new Bag();
        Receipt receipt = lockerRobotManager.saveBag(bag);

        Assert.assertNotNull(receipt);
        Assert.assertEquals(bag, primaryLockerRobot.takeBag(receipt));
    }

    @Test
    public void should_save_to_locker_and_print_a_receipt_when_save_bag_given_manage_1_robot_has_no_available_capacity_and_1_locker_has_available_capacity() {
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Lists.newArrayList(new Locker(1)));
        primaryLockerRobot.saveBag(new Bag());
        Locker locker = new Locker(10);
        LockerRobotManager lockerRobotManager = new LockerRobotManager();
        lockerRobotManager.manageRobot(Lists.newArrayList(primaryLockerRobot));
        lockerRobotManager.manageLocker(Lists.newArrayList(locker));

        Bag bag = new Bag();
        Receipt receipt = lockerRobotManager.saveBag(bag);

        Assert.assertNotNull(receipt);
        Assert.assertEquals(bag, locker.takeBag(receipt));
    }

    @Test
    public void should_throw_LockerIsFullException_when_save_bag_given_1_locker_and_1_robot_are_both_full() {
        Locker locker = new Locker(1);
        locker.saveBag(new Bag());
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Lists.newArrayList(new Locker(1)));
        primaryLockerRobot.saveBag(new Bag());
        LockerRobotManager lockerRobotManager = new LockerRobotManager();
        lockerRobotManager.manageLocker(Lists.newArrayList(locker));
        lockerRobotManager.manageRobot(Lists.newArrayList(primaryLockerRobot));

        assertThrows(LockerIsFullException.class, () -> {
            lockerRobotManager.saveBag(new Bag());
        });
    }

    @Test
    public void should_get_the_right_bag_when_take_the_bag_given_manage_2_robots_not_manage_locker_and_a_valid_receipt() {
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Lists.newArrayList(new Locker(10)));
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Lists.newArrayList(new Locker(10)));
        LockerRobotManager lockerRobotManager = new LockerRobotManager();
        lockerRobotManager.manageRobot(Lists.newArrayList(primaryLockerRobot, smartLockerRobot));
        Bag bag = new Bag();
        Receipt receipt = lockerRobotManager.saveBag(bag);

        Bag retrieveBag = lockerRobotManager.takeBag(receipt);

        Assert.assertEquals(bag, retrieveBag);
    }
}
