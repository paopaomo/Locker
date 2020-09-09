package cn.xpbootcamp.locker;

import java.util.ArrayList;
import java.util.List;

public class LockerRobotManager {
    final private List<Robot> robots = new ArrayList<>();
    final private List<Locker> lockers = new ArrayList<>();

    public void manageRobot(List<Robot> robots) {
        this.robots.addAll(robots);
    }

    public void manageLocker(List<Locker> lockers) {
        this.lockers.addAll(lockers);
    }

    public Receipt saveBag(Bag bag) {
        for(Robot robot: robots) {
            if(robot.hasAvailableCapacity()) {
                return robot.saveBag(bag);
            }
        }
        for(Locker locker: lockers) {
            if(locker.hasAvailableCapacity()) {
                return locker.saveBag(bag);
            }
        }
        throw  new LockerIsFullException();
    }

    public Bag takeBag(Receipt receipt) {
        for(Robot robot: robots) {
            if(robot.existReceipt(receipt)) {
                return robot.takeBag(receipt);
            }
        }
        for(Locker locker: lockers) {
            if(locker.existedReceipt(receipt)) {
                return locker.takeBag(receipt);
            }
        }
        throw new ReceiptIsInvalidException();
    }
}
