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
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Lists.newArrayList(primaryLockerRobot, smartLockerRobot));

        Bag bag = new Bag();
        Receipt receipt = lockerRobotManager.saveBag(bag);

        Assert.assertEquals(bag, primaryLockerRobot.takeBag(receipt));
    }

    @Test
    public void should_save_by_robot2_and_print_a_receipt_when_save_bag_given_robot1_is_full_robot2_has_available_capacity_and_not_manage_locker() {
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Lists.newArrayList(new Locker(1)));
        primaryLockerRobot.saveBag(new Bag());
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Lists.newArrayList(new Locker(10)));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Lists.newArrayList(primaryLockerRobot, smartLockerRobot));

        Bag bag = new Bag();
        Receipt receipt = lockerRobotManager.saveBag(bag);

        Assert.assertEquals(bag, smartLockerRobot.takeBag(receipt));
    }

    @Test
    public void should_throw_LockerIsFullException_when_save_bag_given_2_robots_are_both_full_and_not_manage_locker() {
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Lists.newArrayList(new Locker(1)));
        primaryLockerRobot.saveBag(new Bag());
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Lists.newArrayList(new Locker(1)));
        smartLockerRobot.saveBag(new Bag());
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Lists.newArrayList(primaryLockerRobot, smartLockerRobot));

        assertThrows(LockerIsFullException.class, () -> {
            lockerRobotManager.saveBag(new Bag());
        });
    }
}
