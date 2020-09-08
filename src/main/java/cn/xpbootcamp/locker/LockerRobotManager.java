package cn.xpbootcamp.locker;

import org.assertj.core.util.Lists;

import java.util.ArrayList;

public class LockerRobotManager {
    final private ArrayList<Robot> robots = Lists.newArrayList();
    final private ArrayList<Locker> lockers = Lists.newArrayList();

    public void manageRobot(ArrayList<Robot> robots) {
        this.robots.addAll(robots);
    }

    public void manageLocker(ArrayList<Locker> lockers) {
        this.lockers.addAll(lockers);
    }

    public Receipt saveBag(Bag bag) {
        for(Robot robot: robots) {
            if(!robot.isAllLockerFull()) {
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
