package cn.xpbootcamp.locker;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PrimaryLockerRobotTest {
    @Test
    public void should_save_to_locker1_and_print_a_receipt_when_robot_save_bag_given_many_lockers_are_empty() {
        Locker locker1 = new Locker(10);
        Locker locker2 = new Locker(10);
        PrimaryLockerRobot robot = new PrimaryLockerRobot(List.of(locker1, locker2));

        Bag bag = new Bag();
        Receipt receipt = robot.saveBag(bag);

        Assert.assertNotNull(receipt);
        Assert.assertEquals(bag, locker1.takeBag(receipt));
    }

    @Test
    public void should_save_to_locker2_and_print_a_receipt_when_robot_save_bag_given_locker1_is_full_and_other_lockers_are_empty() {
        Locker locker1 = new Locker(1);
        Locker locker2 = new Locker(10);
        PrimaryLockerRobot robot = new PrimaryLockerRobot(List.of(locker1, locker2));
        locker1.saveBag(new Bag());

        Bag bag = new Bag();
        Receipt receipt = robot.saveBag(bag);

        Assert.assertNotNull(receipt);
        Assert.assertEquals(bag, locker2.takeBag(receipt));
    }

    @Test
    public void should_throw_LockerIsFullException_when_robot_save_bag_given_lockers_are_all_full() {
        Locker locker1 = new Locker(1);
        Locker locker2 = new Locker(1);
        PrimaryLockerRobot robot = new PrimaryLockerRobot(List.of(locker1, locker2));
        locker1.saveBag(new Bag());
        locker2.saveBag(new Bag());

        assertThrows(LockerIsFullException.class, () -> {
            robot.saveBag(new Bag());
        });
    }

    @Test
    public void should_get_right_bag_when_robot_take_the_bag_given_a_valid_receipt() {
        Locker locker1 = new Locker(10);
        PrimaryLockerRobot robot = new PrimaryLockerRobot(List.of(locker1));
        Bag bag = new Bag();
        Receipt receipt = robot.saveBag(bag);

        Bag retrieveBag = robot.takeBag(receipt);

        Assert.assertEquals(bag, retrieveBag);
    }

    @Test
    public void should_throw_ReceiptIsInvalidException_when_robot_take_the_bag_given_a_invalid_receipt() {
        Locker locker1 = new Locker(10);
        PrimaryLockerRobot robot = new PrimaryLockerRobot(List.of(locker1));

        assertThrows(ReceiptIsInvalidException.class, () -> {
            robot.takeBag(new Receipt());
        });
    }
}
