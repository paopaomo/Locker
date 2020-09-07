package cn.xpbootcamp.locker;

import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

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
}
