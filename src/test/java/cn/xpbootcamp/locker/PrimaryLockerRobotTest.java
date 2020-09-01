package cn.xpbootcamp.locker;

import com.sun.tools.javac.util.List;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PrimaryLockerRobotTest {
    @Test
    public void should_save_to_locker1_and_print_a_receipt_when_robot_save_bag_given_many_lockers_are_empty() {
        Locker locker1 = new Locker(10);
        Locker locker2 = new Locker(10);
        Locker locker3 = new Locker(10);
        PrimaryLockerRobot robot = new PrimaryLockerRobot(List.of(locker1, locker2, locker3));

        RobotReceipt robotReceipt = robot.saveBag(new Bag());

        Assert.assertEquals(locker1.getCurrentStorage(), 1);
        Assert.assertEquals(RobotReceipt.class, robotReceipt.getClass());
    }

    @Test
    public void should_save_to_locker2_and_print_a_receipt_when_robot_save_bag_given_locker1_is_full_and_other_lockers_are_empty() {
        Locker locker1 = new Locker(1);
        Locker locker2 = new Locker(10);
        Locker locker3 = new Locker(10);
        PrimaryLockerRobot robot = new PrimaryLockerRobot(List.of(locker1, locker2, locker3));
        locker1.saveBag(new Bag());

        RobotReceipt robotReceipt = robot.saveBag(new Bag());

        Assert.assertEquals(locker2.getCurrentStorage(), 1);
        Assert.assertEquals(RobotReceipt.class, robotReceipt.getClass());
    }

    @Test
    public void should_throw_LockerIsFullException_when_robot_save_bag_given_lockers_are_all_full() {
        Locker locker1 = new Locker(1);
        Locker locker2 = new Locker(1);
        Locker locker3 = new Locker(1);
        PrimaryLockerRobot robot = new PrimaryLockerRobot(List.of(locker1, locker2, locker3));
        locker1.saveBag(new Bag());
        locker2.saveBag(new Bag());
        locker3.saveBag(new Bag());

        assertThrows(LockerIsFullException.class, () -> {
            robot.saveBag(new Bag());
        });
    }

    @Test
    public void should_get_right_bag_when_robot_take_the_bag_given_a_valid_receipt() {
        Locker locker1 = new Locker(10);
        PrimaryLockerRobot robot = new PrimaryLockerRobot(List.of(locker1));
        Bag bag = new Bag();
        RobotReceipt robotReceipt = robot.saveBag(bag);

        Bag retrieveBag = robot.takeBag(robotReceipt);

        Assert.assertEquals(retrieveBag, bag);
    }
}
