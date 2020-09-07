package cn.xpbootcamp.locker;

import java.util.ArrayList;

public class PrimaryLockerRobot extends Robot {
    public PrimaryLockerRobot(ArrayList<Locker> lockers) {
        super(lockers);
    }

    public Receipt saveBag(Bag bag) {
        for (Locker locker : lockers) {
            if (locker.hasAvailableCapacity()) {
                return locker.saveBag(bag);
            }
        }
        throw new LockerIsFullException();
    }
}
